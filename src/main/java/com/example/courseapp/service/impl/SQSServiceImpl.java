package com.example.courseapp.service.impl;

import com.example.courseapp.service.SNSService;
import com.example.courseapp.service.SQSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;


@Service
public class SQSServiceImpl implements SQSService {

    @Autowired
    private QueueMessagingTemplate queueMessagingTemplate;

    @Autowired
    private SNSService snsService;

    @Value("${cloud.aws.end-point.uri}")
    private String endpoint;

    @Override
    public void sendMessageToQueue(String message) {
        queueMessagingTemplate.send(endpoint, MessageBuilder.withPayload(message).build());
    }

//    @Override
//    @SqsListener("task8-upload-notification-queue")
//    public void loadMessageFromSQS(String message)  {
//        sendMessageToSNS(message);
//    }
//
//    public void sendMessageToSNS (String message) {
//        snsService.publishMessage(message);
//    }

}
