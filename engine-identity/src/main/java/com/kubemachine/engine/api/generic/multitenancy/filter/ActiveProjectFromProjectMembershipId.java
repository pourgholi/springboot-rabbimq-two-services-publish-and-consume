package com.kubemachine.engine.api.generic.multitenancy.filter;

import com.kubemachine.engine.api.project.model.Project;
import com.kubemachine.engine.api.project.repository.ProjectRepository;
import com.kubemachine.engine.api.projectmember.model.ProjectMember;
import com.kubemachine.engine.api.projectmember.repository.ProjectMemberRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
@Slf4j
public class ActiveProjectFromProjectMembershipId {
    private final ProjectRepository projectRepository;
    private final ProjectMemberRepository projectMemberRepository;

    public Project getActiveProjectFromActiveProjectMemberAttributeInToken() {
        ProjectMember projectMember = projectMemberRepository.findAllByProjectMembershipId(UUID.fromString("2fe641c3-c605-4cb2-91c2-a86120db178a")).get(0);
        return projectMember.getProject();
    }
}
