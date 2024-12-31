package com.kubemachine.engine.api.projectmember.repository;

import com.kubemachine.engine.api.generic.BaseRepository;
import com.kubemachine.engine.api.project.model.Project;
import com.kubemachine.engine.api.projectmember.model.ProjectMember;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;
import java.util.UUID;

@RepositoryRestResource(collectionResourceRel = "projectMember", path = "projectMember")
public interface ProjectMemberRepository extends BaseRepository<ProjectMember, UUID> {
    List<ProjectMember> findAllByProjectMembershipId(UUID projectMembershipId);
}
