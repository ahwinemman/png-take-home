package com.rukevwe.pubserver.service;

import com.rukevwe.pubserver.command.PublishCommand;
import com.rukevwe.pubserver.command.SubscribeCommand;
import com.rukevwe.pubserver.data.Subscription;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TopicService {

    ResponseEntity publishTopic(PublishCommand publishCommand, String topic);

    Subscription subscribeTopic(SubscribeCommand subscribeCommand, String topic);

    List<Subscription> getSubscribers(String topic);
}
