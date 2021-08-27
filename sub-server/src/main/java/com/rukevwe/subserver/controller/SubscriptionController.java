package com.rukevwe.subserver.controller;

import com.rukevwe.subserver.command.SubscriberCommand;
import com.rukevwe.subserver.models.SubscriberResponse;
import com.rukevwe.subserver.service.SubscriptionService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1")
@AllArgsConstructor
public class SubscriptionController {

    private final SubscriptionService subscriptionService;

    @PostMapping("/{topic}")
    public ResponseEntity<SubscriberResponse> receiveData(@RequestBody @Valid SubscriberCommand subscriberCommand,
                                                          @PathVariable("topic") String topic) {
        return subscriptionService.receiveData(subscriberCommand, topic);
    }

}