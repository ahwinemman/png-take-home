package com.rukevwe.subserver.service;

import com.rukevwe.subserver.command.SubscriberCommand;
import org.springframework.http.ResponseEntity;

public interface SubscriptionService {

    ResponseEntity receiveData(SubscriberCommand publishCommand, String topic);

}
