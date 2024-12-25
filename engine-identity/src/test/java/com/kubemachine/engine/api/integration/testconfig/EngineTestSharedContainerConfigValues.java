package com.kubemachine.engine.api.integration.testconfig;

class EngineTestSharedContainerConfigValues {
    static final String ENGINE_API_POSTGRES_IMAGE = "postgres:11.1";
    static final String ENGINE_API_DB_NAME = "engine-identity-db";
    static final String ENGINE_API_DB_USERNAME = "engine-identity-db";
    static final String ENGINE_API_DB_PASSWORD = "engine-identity-db";
    static final String ENGINE_MESSAGE_BROKER_IMAGE = "rabbitmq:3.7-management";
    static final int ENGINE_MESSAGE_BROKER_PORT = 5672;
    static final boolean ENGINE_MESSAGE_BROKER_ACCESS_TO_HOST = true;
    static final String ENGINE_MESSAGE_BROKER_USERNAME = "admin";
    static final String ENGINE_MESSAGE_BROKER_PASSWORD = "admin";
}
