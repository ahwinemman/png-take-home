package com.rukevwe.pubserver.command;


import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class PublishCommand {
    @NotBlank
    private String data;
}
