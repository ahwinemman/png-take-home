package com.rukevwe.pubserver.controller;

import com.rukevwe.pubserver.command.PublishCommand;
import com.rukevwe.pubserver.command.SubscribeCommand;
import com.rukevwe.pubserver.data.Subscription;
import com.rukevwe.pubserver.service.TopicService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/v1")
@AllArgsConstructor
public class TopicController {

    private final TopicService topicService;

    @PostMapping("/publish/{topic}")
    public ResponseEntity publishTopic(@RequestBody @Valid PublishCommand publishCommand, @PathVariable("topic") String topic) {
        return topicService.publishTopic(publishCommand, topic);
    }

    @PostMapping("/subscribe/{topic}")
    public Subscription subscribeTopic(@RequestBody @Valid SubscribeCommand subscribeCommand, @PathVariable("topic") String topic) {
       return topicService.subscribeTopic(subscribeCommand, topic);
    }

    @GetMapping("/subscribers/{topic}")
    public List<Subscription> getSubscribers(@PathVariable("topic") String topic) {
       return topicService.getSubscribers(topic);
    }
}
