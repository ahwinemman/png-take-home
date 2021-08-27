package com.rukevwe.pubserver.command;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class SubscribeCommand {
    @NotBlank
    private String url;
}
