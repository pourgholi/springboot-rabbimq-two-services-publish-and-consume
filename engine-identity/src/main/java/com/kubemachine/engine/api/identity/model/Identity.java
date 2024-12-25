package com.kubemachine.engine.api.identity.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.kubemachine.engine.api.audit.model.AuditMetadata;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.UUID;

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
