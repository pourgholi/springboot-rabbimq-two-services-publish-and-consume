package com.kubemachine.engine.api.project.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.kubemachine.engine.api.audit.model.BasicAuditMetadata;
import jakarta.persistence.Entity;
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
public class Project extends BasicAuditMetadata implements Serializable {

    private String projectName;
}
