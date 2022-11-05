package com.jan.magicmarket.config.rest;

import com.fasterxml.jackson.annotation.JsonValue;
import com.jan.magicmarket.config.constants.Labeled;

public enum ResponseMessage implements Labeled<String> {
    ERROR_OCCURRED("An error occurred"),
    ENTITY_NOT_FOUND("The entity could not be found"),
    ENTITY_NOT_CREATED("The entity could not be created"),
    ENTITY_NOT_CHANGED("The information related to the entity could not be changed"),
    ENTITY_NOT_DELETED("The entity could not be deleted"),
    ENTITY_FOUND("The entity was successfully retrieved"),
    ENTITY_CREATED("The entity has successfully been created"),
    ENTITY_CHANGED("The entity has successfully been changed"),
    ENTITY_DELETED("The entity has successfully been deleted"),
    INFORMATION_CHANGED("The information was successfully changed");

    private final String label;

    ResponseMessage(String label) {
        this.label = label;
    }

    @JsonValue
    @Override
    public String getLabel() {
        return label;
    }
}
