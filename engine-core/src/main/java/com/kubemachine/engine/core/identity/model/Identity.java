package com.kubemachine.engine.core.identity.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Identity {
    private UUID id;
    private String identityFirstName;
    private String identityLastName;
    private String progressStatus;
    private String identityStatus;
}
