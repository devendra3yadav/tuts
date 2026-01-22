# 6. Testing in Enterprise Applications

This directory contains examples for understanding different types of testing.

## Files

### Unit Tests
- `unit-tests/UserServiceTest.java` - Unit testing with Hamcrest matchers

### Repository Tests
- `repository-tests/UserRepositoryTest.java` - Testing persistence layer

### RestAssured Tests
- `restassured-tests/UserControllerRestAssuredTest.java` - REST API testing

## Key Concepts

### Unit Testing
- Testing individual units in isolation
- Using mocks for dependencies
- One behavior per test
- Hamcrest matchers for readable assertions

### Repository Testing
- Testing persistence layer
- CRUD operations validation
- Custom query testing
- In-memory vs real database

### RestAssured Testing
- REST API testing
- Status code validation
- Response body and header validation
- API contract verification

## Study Order

1. **Unit Tests**: Read `unit-tests/UserServiceTest.java`
   - Understand mocking with Mockito
   - Learn Hamcrest matchers
   - See unit testing best practices

2. **Repository Tests**: Read `repository-tests/UserRepositoryTest.java`
   - Understand @DataJpaTest
   - See CRUD operation testing
   - Learn query validation

3. **RestAssured Tests**: Read `restassured-tests/UserControllerRestAssuredTest.java`
   - Understand REST API testing
   - See status code validation
   - Learn response validation
