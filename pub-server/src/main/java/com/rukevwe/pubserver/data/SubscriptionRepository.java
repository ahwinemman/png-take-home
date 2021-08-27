package com.rukevwe.pubserver.data;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SubscriptionRepository extends CrudRepository<Subscription, Long> {

    @Override
    Subscription save(Subscription subscription);

    Subscription findByUrlAndTopic(String url, String topic);

    List<Subscription> findByTopic(String topic);


}
