package com.rukevwe.subserver.service;

import com.rukevwe.subserver.command.SubscriberCommand;
import com.rukevwe.subserver.models.SubscriberResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class SubscriptionServiceImpl implements SubscriptionService{

    @Override
    public ResponseEntity<SubscriberResponse> receiveData(SubscriberCommand subscriberCommand, String topic) {
        log.info("Data with topic {} obtained from publisher: {}", topic, subscriberCommand.getData());
        return new ResponseEntity(new SubscriberResponse(topic, subscriberCommand.getData()), HttpStatus.OK);
    }
}
