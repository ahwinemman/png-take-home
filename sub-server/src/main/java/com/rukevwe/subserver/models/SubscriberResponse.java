package com.rukevwe.subserver.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SubscriberResponse {
    private String topic;
    private String data;
}
