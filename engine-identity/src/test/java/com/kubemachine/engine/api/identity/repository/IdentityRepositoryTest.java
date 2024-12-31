package com.kubemachine.engine.api.identity.repository;

import com.kubemachine.engine.api.identity.model.Identity;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration(classes = TestConfig.class)
@Disabled
public class IdentityRepositoryTest {

    enum ProgressStatus {
        IN_PROGRESS
    }

    enum IdentityStatus {
        ACTIVE
    }

    enum IdentityFirstName {
        FIRST_NAME
    }

    enum IdentityLastName {
        IDENTITY_LAST_NAME
    }


    @Value("${local.server.port}")
    private int port;

    private String createIdentityAndGetId(String identityFirstName, String identityLastName, String progressStatus, String identityStatus) {
        var identity = new Identity(identityFirstName, identityLastName, progressStatus, identityStatus);

        return given()
                .contentType(ContentType.JSON)
                .body(identity)
                .port(port)
                .when()
                .post("/api/identity/")
                .then()
                .statusCode(201)
                .extract()
                .path("id");
    }


    @Test
    void shouldCreateUser() {
        var identity = new Identity(IdentityFirstName.FIRST_NAME.name(), IdentityLastName.IDENTITY_LAST_NAME.name(), ProgressStatus.IN_PROGRESS.name(), IdentityStatus.ACTIVE.name());

        given()
                .contentType(ContentType.JSON)
                .body(identity)
                .port(port)
                .when()
                .post("/api/identity")
                .then()
                .statusCode(201)
                .body("identityFirstName", equalTo(IdentityFirstName.FIRST_NAME.name()));

    }
//    @Test
//    void shouldDeleteUserById() {
//        String userId = createUserAndGetId("Test user");
//
//        given()
//                .port(port)
//                .when()
//                .delete("/users/{id}", userId)
//                .then()
//                .statusCode(204)
//                .body(emptyOrNullString());
//    }
//
//    @Test
//    void shouldGetAllUsers() {
//        createUserAndGetId("Test user");
//
//        given()
//                .port(port)
//                .when()
//                .get("/users/")
//                .then()
//                .statusCode(200)
//                .body("size()", greaterThan(0));
//    }
//
//    @Test
//    void shouldGetUserById() {
//        String userId = createUserAndGetId("Test user");
//
//        given()
//                .port(port)
//                .when()
//                .get("/users/{id}", userId)
//                .then()
//                .statusCode(200)
//                .body("id", equalTo(userId))
//                .body("name", equalTo("Test user"));
//
//    }
//
//    @Test
//    void shouldReturn500WhenSearchForNonExistentUser() {
//        String nonExistentUserId = "9999";
//
//        given()
//                .port(port)
//                .when()
//                .get("/users/{id}", nonExistentUserId)
//                .then()
//                .statusCode(500);
//    }
//
//    @Test
//    void shouldReturn500WhenDeletingNonExistentUser() {
//        String nonExistentUserId = "9999";
//
//        given()
//                .port(port)
//                .when()
//                .delete("/users/{id}", nonExistentUserId)
//                .then()
//                .statusCode(500);
//    }


//    @Autowired
//    private IdentityRepository identityRepository;

//    @Test
//    void identityTest() {
//        // Save identity
//        var identity = new Identity();
//        identity.setIdentityFirstName(TEST_CLUSTER_NAME);
//        identity.setIdentityLastName(TEST_CLUSTER_URL);
//        identityRepository.save(identity);
//
//        // Load identity
//        var loadedIdentity = identityRepository.findAll().stream().findFirst();
//
//        // Test loaded identity
//        assertThat(loadedIdentity).isNotEmpty();
//        assertEquals(loadedIdentity.get().getIdentityFirstName(), TEST_CLUSTER_NAME);
//        assertEquals(loadedIdentity.get().getIdentityLastName(), TEST_CLUSTER_URL);
//
//    }
}
