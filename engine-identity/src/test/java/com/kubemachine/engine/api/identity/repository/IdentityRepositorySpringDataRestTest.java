package com.kubemachine.engine.api.identity.repository;

import com.kubemachine.engine.api.identity.model.Identity;
import com.kubemachine.engine.api.project.model.Project;
import com.kubemachine.engine.api.project.repository.ProjectRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.UUID;

@ContextConfiguration(classes = TestConfig.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class IdentityRepositorySpringDataRestTest {

    @Autowired
    IdentityRepository identityRepository;

    @Autowired
    ProjectRepository projectRepository;


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

    @Test
    void shouldCreateIdentity() {
        var identity = new Identity(IdentityFirstName.FIRST_NAME.name(), IdentityLastName.IDENTITY_LAST_NAME.name(), ProgressStatus.IN_PROGRESS.name(), IdentityStatus.ACTIVE.name());
        var project = new Project("Test project");

        Project savedProject = projectRepository.save(project);
        identity.setProject(savedProject);

        Identity x = identityRepository.save(identity);



    }
}
