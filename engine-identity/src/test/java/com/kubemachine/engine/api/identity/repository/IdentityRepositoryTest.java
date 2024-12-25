package com.kubemachine.engine.api.identity.repository;

import com.kubemachine.engine.api.identity.model.Identity;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest(properties = {"spring.test.database.replace=NONE", "spring.datasource.url=jdbc:tc:postgresql:12:///springboot"})
@TestPropertySource(properties = "spring.config.additional-location=classpath:application-test.yml")
public class IdentityRepositoryTest {

    public static final String TEST_CLUSTER_NAME = "testIdentityName";
    public static final String TEST_CLUSTER_URL = "testIdentityUrl";

    @Autowired
    private IdentityRepository identityRepository;

    @Test
    void identityTest() {
        // Save identity
        var identity = new Identity();
        identity.setIdentityFirstName(TEST_CLUSTER_NAME);
        identity.setIdentityLastName(TEST_CLUSTER_URL);
        identityRepository.save(identity);

        // Load identity
        var loadedIdentity = identityRepository.findAll().stream().findFirst();

        // Test loaded identity
        assertThat(loadedIdentity).isNotEmpty();
        assertEquals(loadedIdentity.get().getIdentityFirstName(), TEST_CLUSTER_NAME);
        assertEquals(loadedIdentity.get().getIdentityLastName(), TEST_CLUSTER_URL);

    }
}
