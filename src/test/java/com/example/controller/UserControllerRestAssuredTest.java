package com.example.controller;

import com.example.model.User;
import com.example.repository.UserRepository;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

/**
 * RestAssured Tests
 * 
 * Purpose of RestAssured:
 * - Testing REST APIs in a fluent, readable way
 * - Validates HTTP responses, status codes, headers, and body
 * - Makes API testing similar to unit testing
 * 
 * REST API Testing Concepts:
 * - Status Code Validation: Verify correct HTTP status codes
 * - Response Body Validation: Check response content
 * - Header Validation: Verify response headers
 * - API Contract Verification: Ensure API behaves as expected
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@DisplayName("UserController REST API Tests")
class UserControllerRestAssuredTest {
    
    @LocalServerPort
    private int port;
    
    @Autowired
    private UserRepository userRepository;
    
    @BeforeEach
    void setUp() {
        RestAssured.port = port;
        RestAssured.baseURI = "http://localhost";
        userRepository.deleteAll();
    }
    
    /**
     * Status Code Validation
     */
    @Test
    @DisplayName("Should create user and return 201 status")
    void shouldCreateUserAndReturn201Status() {
        User user = new User(null, "johndoe", "john@example.com", "John", "Doe");
        
        given()
            .contentType(ContentType.JSON)
            .body(user)
        .when()
            .post("/api/users")
        .then()
            .statusCode(201)  // Status code validation
            .body("id", is(notNullValue()))  // Response body validation
            .body("username", is(equalTo("johndoe")))
            .body("email", is(equalTo("john@example.com")));
    }
    
    /**
     * Response Body and Headers Validation
     */
    @Test
    @DisplayName("Should retrieve user by ID with correct response")
    void shouldRetrieveUserById() {
        // Arrange: Create a user first
        User savedUser = userRepository.save(
            new User(null, "johndoe", "john@example.com", "John", "Doe")
        );
        
        // Act & Assert
        given()
        .when()
            .get("/api/users/{id}", savedUser.getId())
        .then()
            .statusCode(200)
            .contentType(ContentType.JSON)  // Header validation
            .body("id", is(equalTo(savedUser.getId().intValue())))
            .body("username", is(equalTo("johndoe")))
            .body("email", is(equalTo("john@example.com")))
            .body("firstName", is(equalTo("John")))
            .body("lastName", is(equalTo("Doe")));
    }
    
    /**
     * Status Code Validation: Not Found
     */
    @Test
    @DisplayName("Should return 404 when user not found")
    void shouldReturn404WhenUserNotFound() {
        given()
        .when()
            .get("/api/users/999")
        .then()
            .statusCode(404);  // Status code validation for error case
    }
    
    /**
     * API Contract Verification: GET all users
     */
    @Test
    @DisplayName("Should retrieve all users")
    void shouldRetrieveAllUsers() {
        // Arrange: Create multiple users
        userRepository.save(new User(null, "user1", "user1@example.com", "User", "One"));
        userRepository.save(new User(null, "user2", "user2@example.com", "User", "Two"));
        
        // Act & Assert
        given()
        .when()
            .get("/api/users")
        .then()
            .statusCode(200)
            .contentType(ContentType.JSON)
            .body("size()", is(greaterThanOrEqualTo(2)))  // Collection validation
            .body("username", hasItems("user1", "user2"));  // Collection contains items
    }
    
    /**
     * API Contract Verification: Update user
     */
    @Test
    @DisplayName("Should update user successfully")
    void shouldUpdateUserSuccessfully() {
        // Arrange
        User savedUser = userRepository.save(
            new User(null, "johndoe", "john@example.com", "John", "Doe")
        );
        
        User updatedUser = new User(
            savedUser.getId(), 
            "johndoe", 
            "john.updated@example.com", 
            "John", 
            "Doe"
        );
        
        // Act & Assert
        given()
            .contentType(ContentType.JSON)
            .body(updatedUser)
        .when()
            .put("/api/users/{id}", savedUser.getId())
        .then()
            .statusCode(200)
            .body("id", is(equalTo(savedUser.getId().intValue())))
            .body("email", is(equalTo("john.updated@example.com")));
    }
    
    /**
     * API Contract Verification: Delete user
     */
    @Test
    @DisplayName("Should delete user and return 204 status")
    void shouldDeleteUserAndReturn204Status() {
        // Arrange
        User savedUser = userRepository.save(
            new User(null, "johndoe", "john@example.com", "John", "Doe")
        );
        
        // Act & Assert
        given()
        .when()
            .delete("/api/users/{id}", savedUser.getId())
        .then()
            .statusCode(204);  // No Content status code
        
        // Verify deletion
        given()
        .when()
            .get("/api/users/{id}", savedUser.getId())
        .then()
            .statusCode(404);
    }
    
    /**
     * Response Header Validation Example
     */
    @Test
    @DisplayName("Should return correct content type header")
    void shouldReturnCorrectContentTypeHeader() {
        userRepository.save(new User(null, "johndoe", "john@example.com", "John", "Doe"));
        
        given()
        .when()
            .get("/api/users")
        .then()
            .statusCode(200)
            .contentType(ContentType.JSON)  // Header validation
            .header("Content-Type", containsString("application/json"));  // Explicit header check
    }
}
