package com.kubemachine.engine.api.project.repository;


import com.kubemachine.engine.api.generic.BaseRepository;
import com.kubemachine.engine.api.project.model.Project;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.UUID;

@RepositoryRestResource(collectionResourceRel = "project", path = "project")
public interface ProjectRepository extends BaseRepository<Project, UUID> {
//    List<Project> findAllByProjectName(String projectName);
//
//    @Query("select proj from Project proj where proj.createdByUser = :userId")
//    List<Project> findAllProjectForGivenUserId(@Param("userId") UUID userId);
}
