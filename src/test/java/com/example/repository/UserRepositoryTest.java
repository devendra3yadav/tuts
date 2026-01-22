package com.example.repository;

import com.example.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * Repository Tests
 * 
 * What Repository Tests Are:
 * - Tests that validate the persistence layer
 * - Test database interactions and queries
 * - Verify CRUD operations work correctly
 * 
 * Testing Persistence Layer:
 * - Use @DataJpaTest for repository testing
 * - Uses in-memory database (H2) by default
 * - Tests actual database queries and constraints
 * 
 * Role of In-Memory vs Real Database:
 * - In-memory (H2): Fast, isolated, good for unit testing
 * - Real database: Integration testing, verify database-specific features
 * 
 * Importance of Repository Testing:
 * - Ensures data persistence works correctly
 * - Validates custom queries
 * - Tests database constraints and relationships
 */
@DataJpaTest
@DisplayName("UserRepository Tests")
class UserRepositoryTest {
    
    @Autowired
    private TestEntityManager entityManager;
    
    @Autowired
    private UserRepository userRepository;
    
    private User testUser;
    
    @BeforeEach
    void setUp() {
        testUser = new User(null, "johndoe", "john@example.com", "John", "Doe");
    }
    
    /**
     * CRUD Test: Create
     */
    @Test
    @DisplayName("Should save user to database")
    void shouldSaveUserToDatabase() {
        // Act
        User savedUser = userRepository.save(testUser);
        
        // Assert
        assertThat(savedUser.getId(), is(notNullValue()));
        assertThat(savedUser.getUsername(), is(equalTo("johndoe")));
        
        // Verify it's actually in the database
        User foundUser = entityManager.find(User.class, savedUser.getId());
        assertThat(foundUser, is(notNullValue()));
        assertThat(foundUser.getUsername(), is(equalTo("johndoe")));
    }
    
    /**
     * CRUD Test: Read
     */
    @Test
    @DisplayName("Should find user by ID")
    void shouldFindUserById() {
        // Arrange
        User savedUser = entityManager.persistAndFlush(testUser);
        
        // Act
        Optional<User> foundUser = userRepository.findById(savedUser.getId());
        
        // Assert
        assertThat(foundUser.isPresent(), is(true));
        assertThat(foundUser.get().getUsername(), is(equalTo("johndoe")));
    }
    
    /**
     * Query Validation: Custom query method
     */
    @Test
    @DisplayName("Should find user by username")
    void shouldFindUserByUsername() {
        // Arrange
        entityManager.persistAndFlush(testUser);
        
        // Act
        Optional<User> foundUser = userRepository.findByUsername("johndoe");
        
        // Assert
        assertThat(foundUser.isPresent(), is(true));
        assertThat(foundUser.get().getUsername(), is(equalTo("johndoe")));
    }
    
    @Test
    @DisplayName("Should find user by email")
    void shouldFindUserByEmail() {
        // Arrange
        entityManager.persistAndFlush(testUser);
        
        // Act
        Optional<User> foundUser = userRepository.findByEmail("john@example.com");
        
        // Assert
        assertThat(foundUser.isPresent(), is(true));
        assertThat(foundUser.get().getEmail(), is(equalTo("john@example.com")));
    }
    
    /**
     * Query Validation: Existence check
     */
    @Test
    @DisplayName("Should return true when username exists")
    void shouldReturnTrueWhenUsernameExists() {
        // Arrange
        entityManager.persistAndFlush(testUser);
        
        // Act
        boolean exists = userRepository.existsByUsername("johndoe");
        
        // Assert
        assertThat(exists, is(true));
    }
    
    @Test
    @DisplayName("Should return false when username does not exist")
    void shouldReturnFalseWhenUsernameDoesNotExist() {
        // Act
        boolean exists = userRepository.existsByUsername("nonexistent");
        
        // Assert
        assertThat(exists, is(false));
    }
    
    /**
     * CRUD Test: Update
     */
    @Test
    @DisplayName("Should update user in database")
    void shouldUpdateUserInDatabase() {
        // Arrange
        User savedUser = entityManager.persistAndFlush(testUser);
        savedUser.setEmail("john.updated@example.com");
        
        // Act
        User updatedUser = userRepository.save(savedUser);
        
        // Assert
        assertThat(updatedUser.getEmail(), is(equalTo("john.updated@example.com")));
        
        // Verify update persisted
        User foundUser = entityManager.find(User.class, savedUser.getId());
        assertThat(foundUser.getEmail(), is(equalTo("john.updated@example.com")));
    }
    
    /**
     * CRUD Test: Delete
     */
    @Test
    @DisplayName("Should delete user from database")
    void shouldDeleteUserFromDatabase() {
        // Arrange
        User savedUser = entityManager.persistAndFlush(testUser);
        
        // Act
        userRepository.deleteById(savedUser.getId());
        entityManager.flush();
        
        // Assert
        User foundUser = entityManager.find(User.class, savedUser.getId());
        assertThat(foundUser, is(nullValue()));
    }
}
