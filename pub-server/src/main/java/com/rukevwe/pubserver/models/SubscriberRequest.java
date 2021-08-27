package com.rukevwe.pubserver.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SubscriberRequest {
    private String topic;
    private String data;

}
