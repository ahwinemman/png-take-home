package com.rukevwe.subserver.command;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SubscriberCommand {
    private String topic;
    private String data;
}
