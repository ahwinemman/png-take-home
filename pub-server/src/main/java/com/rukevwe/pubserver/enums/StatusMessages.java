package com.rukevwe.pubserver.enums;

public enum StatusMessages {

    PUBLISH_SUCCESS("Publish successful for topic"),
    PUBLISH_FAILED("Publish failed for topic"),
    PUBLISH_NO_SUBSCRIBERS("No Subscribers yet for this topic"),
    SUBSCRIPTION_FAILED("Failed to subscribe to topic");

    private String message;

    StatusMessages(String message) {
        this.message = message;
    }

}
