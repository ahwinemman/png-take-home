package com.rukevwe.pubserver.service;

import com.rukevwe.pubserver.command.PublishCommand;
import com.rukevwe.pubserver.command.SubscribeCommand;
import com.rukevwe.pubserver.data.Subscription;
import com.rukevwe.pubserver.data.SubscriptionRepository;
import com.rukevwe.pubserver.models.SubscriberRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TopicServiceImpl implements TopicService {

    private final SubscriptionRepository subscriptionRepository;
    private final RestTemplate restTemplate;

    @Override
    public ResponseEntity publishTopic(PublishCommand publishCommand, String topic) {

        List<Subscription> subscriptions = subscriptionRepository.findByTopic(topic);

        if (subscriptions.isEmpty()) {
            log.info("No subscribers found for topic {}", topic);
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        for (Subscription subscription : subscriptions) {
            SubscriberRequest body = new SubscriberRequest(topic, publishCommand.getData());
            try {
                restTemplate.postForObject(subscription.getUrl(), body, Void.class);
                log.info("Successfully sent data to subscriber with url {}", subscription.getUrl());
            } catch (Exception ex) {
                log.error("Failed to send data to subscriber with url {}", subscription.getUrl(), ex);
                return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        return new ResponseEntity(HttpStatus.OK);
    }

    @Override
    public Subscription subscribeTopic(SubscribeCommand subscribeCommand, String topic) {

        String url = subscribeCommand.getUrl();

        Subscription subscription = subscriptionRepository.findByUrlAndTopic(subscribeCommand.getUrl(), topic);
        if (subscription != null) {
            log.info("Url: {}, already subscribed to topic {}", url, topic);
            return subscription;
        }

        subscription = new Subscription();
        subscription.setTopic(topic);
        subscription.setUrl(url);

        subscription = subscriptionRepository.save(subscription);

        log.info("Url: {}, successfully subscribed to topic {}", url, topic);

        return subscription;
    }

    @Override
    public List<Subscription> getSubscribers(String topic) {
        List<Subscription> subscriptions = subscriptionRepository.findByTopic(topic);
        return subscriptions;

    }

}
