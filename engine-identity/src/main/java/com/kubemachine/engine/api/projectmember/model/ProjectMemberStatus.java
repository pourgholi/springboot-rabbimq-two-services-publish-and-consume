package com.kubemachine.engine.api.projectmember.model;

public enum ProjectMemberStatus {
    ENABLED("ENABLED"),
    DISABLED("DISABLED"); // SUSPENDED

    private final String projectMemberStatus;

    ProjectMemberStatus(String projectMemberStatus) {
        this.projectMemberStatus = projectMemberStatus;
    }
    public String getProjectMemberStatus() {
        return this.projectMemberStatus;
    }
}
