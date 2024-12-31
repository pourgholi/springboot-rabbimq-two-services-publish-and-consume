package com.kubemachine.engine.api.projectmember.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.kubemachine.engine.api.audit.model.BasicAuditMetadata;
import com.kubemachine.engine.api.project.model.Project;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
public class ProjectMember extends BasicAuditMetadata implements Serializable {

    @NotNull
    private UUID userId;

    @NotNull
    private UUID projectMembershipId = UUID.fromString("2fe641c3-c605-4cb2-91c2-a86120db178a");

    @Enumerated(EnumType.STRING)
    @NotNull
    private ProjectMemberStatus projectMemberStatus;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne
    @NotNull
    private Project project;
}
