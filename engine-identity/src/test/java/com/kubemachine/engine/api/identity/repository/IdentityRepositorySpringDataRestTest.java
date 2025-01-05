package com.kubemachine.engine.api.identity.repository;

import com.kubemachine.engine.api.identity.model.Identity;
import com.kubemachine.engine.api.identity.model.IdentityStatus;
import com.kubemachine.engine.api.identity.process.newidentity.ProgressStatus;
import com.kubemachine.engine.api.identity.testconstants.EntityAttributes;
import com.kubemachine.engine.api.project.model.Project;
import com.kubemachine.engine.api.project.repository.ProjectRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ContextConfiguration(classes = TestConfig.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class IdentityRepositorySpringDataRestTest {

    @Autowired
    IdentityRepository identityRepository;

    @Autowired
    ProjectRepository projectRepository;


    @Test
    void shouldCreateIdentity() {
        var identity = new Identity(EntityAttributes.FIRST_NAME.name(),
                EntityAttributes.IDENTITY_LAST_NAME.name(),
                ProgressStatus.IN_PROGRESS.name(),
                IdentityStatus.ACTIVE.name());
        var project = new Project("Test project");

        Project savedProject = projectRepository.save(project);
        identity.setProject(savedProject);

        Identity x = identityRepository.save(identity);
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 4})
    void checkEvenNumber(int number) {
        assertEquals(0, number % 2,"Supplied number is not an even number");
    }

}
