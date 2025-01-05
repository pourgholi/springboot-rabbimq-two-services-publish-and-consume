package com.kubemachine.engine.api.identity.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kubemachine.engine.api.identity.model.Identity;

import com.kubemachine.engine.api.identity.model.IdentityStatus;
import com.kubemachine.engine.api.identity.process.newidentity.ProgressStatus;
import com.kubemachine.engine.api.identity.testconstants.EntityAttributes;
import com.kubemachine.engine.api.project.model.Project;
import com.kubemachine.engine.api.project.repository.ProjectRepository;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.stream.Stream;

import static com.kubemachine.engine.api.identity.testutil.HateoasObjectLinkSetter.getJsonInHalFormat;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration(classes = TestConfig.class)
public class IdentityRepositoryTest {

    public Stream<Arguments> createIdentities() {
        Project project = setupProjectAndGetUuid();
        Identity identity1 = new Identity(EntityAttributes.FIRST_NAME.name(), EntityAttributes.IDENTITY_LAST_NAME.name(), ProgressStatus.IN_PROGRESS.name(), IdentityStatus.ACTIVE.name());
        identity1.setProject(project);
        Identity identity2 = new Identity(EntityAttributes.FIRST_NAME.name(), EntityAttributes.IDENTITY_LAST_NAME.name(), ProgressStatus.CONSOLIDATED.name(), IdentityStatus.ACTIVE.name());
        identity2.setProject(project);
        return Stream.of(Arguments.arguments(identity1), Arguments.arguments(identity2));
    }

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    IdentityRepository identityRepository;

    private Project setupProjectAndGetUuid() {
        var project = new Project("Test project");
        return projectRepository.save(project);
    }

    @Value("${local.server.port}")
    private int port;

    @ParameterizedTest
    @MethodSource("createIdentities")
    void shouldCreateMultipleUser(Identity identity) throws JsonProcessingException {
        given()
                .contentType(ContentType.JSON)
                .body(identity)
                .port(port)
                .when()
                .post("/api/identity")
                .then()
                .statusCode(500);
    }

    @ParameterizedTest
    @MethodSource("createIdentities")
    void shouldCreateMultipleUserHateoas(Identity identity) throws JsonProcessingException {
        String jsonInHalFormat = getJsonInHalFormat(identity);
        given()
                .contentType(ContentType.JSON)
                .body(jsonInHalFormat)
                .port(port)
                .when()
                .post("/api/identity")
                .then()
                .statusCode(201)
                .body("identityFirstName", equalTo(EntityAttributes.FIRST_NAME.name()));

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
