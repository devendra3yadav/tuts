package com.example.service;

import com.example.model.User;
import com.example.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

/**
 * Unit Testing Examples
 * 
 * What is Unit Testing:
 * - Testing individual units of code in isolation
 * - A unit is typically a single method or class
 * - Tests should be fast, independent, and repeatable
 * 
 * Why Unit Testing is Important:
 * - Catch bugs early in development
 * - Document expected behavior
 * - Enable refactoring with confidence
 * - Part of CI/CD pipeline
 * 
 * Testing in Isolation:
 * - Use mocks to isolate the unit under test
 * - Mock dependencies (repositories, services, etc.)
 * - Test one behavior per test method
 */
@ExtendWith(MockitoExtension.class)
@DisplayName("UserService Unit Tests")
class UserServiceTest {
    
    @Mock
    private UserRepository userRepository;
    
    @InjectMocks
    private UserService userService;
    
    private User testUser;
    
    @BeforeEach
    void setUp() {
        testUser = new User(1L, "johndoe", "john@example.com", "John", "Doe");
    }
    
    /**
     * Unit Test Best Practice: One behavior per test
     * Test name clearly describes what is being tested
     */
    @Test
    @DisplayName("Should create user successfully")
    void shouldCreateUserSuccessfully() {
        // Arrange (Given)
        when(userRepository.save(any(User.class))).thenReturn(testUser);
        
        // Act (When)
        User result = userService.createUser(testUser);
        
        // Assert (Then)
        assertThat(result, is(notNullValue()));
        assertThat(result.getId(), is(equalTo(1L)));
        assertThat(result.getUsername(), is(equalTo("johndoe")));
        
        // Verify interaction
        verify(userRepository, times(1)).save(testUser);
    }
    
    /**
     * Hamcrest Matchers Example
     * 
     * What are Matchers:
     * - Expressive assertions that read like natural language
     * - More readable than simple assertEquals
     * 
     * Why Hamcrest:
     * - Readable and expressive assertions
     * - Better error messages
     * - Composable matchers
     */
    @Test
    @DisplayName("Should retrieve user by ID using Hamcrest matchers")
    void shouldRetrieveUserById() {
        // Arrange
        when(userRepository.findById(1L)).thenReturn(Optional.of(testUser));
        
        // Act
        Optional<User> result = userService.getUserById(1L);
        
        // Assert with Hamcrest
        assertThat(result, is(not(Optional.empty())));
        assertThat(result.isPresent(), is(true));
        assertThat(result.get().getUsername(), is(equalTo("johndoe")));
        assertThat(result.get().getEmail(), containsString("@example.com"));
    }
    
    @Test
    @DisplayName("Should return empty when user not found")
    void shouldReturnEmptyWhenUserNotFound() {
        // Arrange
        when(userRepository.findById(999L)).thenReturn(Optional.empty());
        
        // Act
        Optional<User> result = userService.getUserById(999L);
        
        // Assert
        assertThat(result, is(Optional.empty()));
        assertThat(result.isPresent(), is(false));
    }
    
    @Test
    @DisplayName("Should retrieve all users")
    void shouldRetrieveAllUsers() {
        // Arrange
        List<User> users = Arrays.asList(
            testUser,
            new User(2L, "janedoe", "jane@example.com", "Jane", "Doe")
        );
        when(userRepository.findAll()).thenReturn(users);
        
        // Act
        List<User> result = userService.getAllUsers();
        
        // Assert with Hamcrest collection matchers
        assertThat(result, is(not(empty())));
        assertThat(result.size(), is(equalTo(2)));
        assertThat(result, hasItem(testUser));
        assertThat(result, hasSize(2));
    }
    
    @Test
    @DisplayName("Should update user successfully")
    void shouldUpdateUserSuccessfully() {
        // Arrange
        User updatedUser = new User(1L, "johndoe", "john.updated@example.com", "John", "Doe");
        when(userRepository.save(any(User.class))).thenReturn(updatedUser);
        
        // Act
        User result = userService.updateUser(updatedUser);
        
        // Assert
        assertThat(result.getEmail(), is(equalTo("john.updated@example.com")));
        verify(userRepository, times(1)).save(updatedUser);
    }
    
    @Test
    @DisplayName("Should delete user by ID")
    void shouldDeleteUserById() {
        // Arrange
        doNothing().when(userRepository).deleteById(1L);
        
        // Act
        userService.deleteUser(1L);
        
        // Assert
        verify(userRepository, times(1)).deleteById(1L);
    }
    
    /**
     * Unit Testing Best Practices Demonstrated:
     * 1. One behavior per test ✓
     * 2. Independent tests (each test is isolated) ✓
     * 3. Meaningful test names ✓
     * 4. Avoid implementation details (test behavior, not implementation) ✓
     * 5. Mocking dependencies ✓
     */
}
