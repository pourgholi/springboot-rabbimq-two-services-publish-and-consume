package com.kubemachine.engine.api.identity.testutil;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import com.kubemachine.engine.api.audit.model.AuditMetadata;

public class HateoasObjectLinkSetter {
    public static String getJsonInHalFormat(AuditMetadata auditMetadata) throws JsonProcessingException {
        return JsonPath.parse(new ObjectMapper().writeValueAsString(auditMetadata))
                .set("$.project", "/".concat(auditMetadata.getProject().getId().toString()))
                .jsonString();
    }
}
