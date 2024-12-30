package com.kubemachine.engine.api.identity.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.kubemachine.engine.api.audit.model.AuditMetadata;
import jakarta.persistence.Entity;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
public class Identity extends AuditMetadata implements Serializable {
    private String identityFirstName;
    private String identityLastName;
    private String progressStatus;
    private String identityStatus;
}
