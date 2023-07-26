package com.example.courseapp.service.impl;

import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.SubscribeRequest;
import com.amazonaws.services.sns.model.UnsubscribeRequest;
import com.example.courseapp.service.SNSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SNSServiceImpl implements SNSService {

    @Value("${cloud.aws.credentials.access-key}")
    private String accessKey;
    @Value("${cloud.aws.credentials.secret-key}")
    private String secretKey;
    @Value("${cloud.aws.region.static}")
    private String region;
    @Value("${cloud.aws.credentials.sns-topic-arn}")
    private String arn;

    @Autowired
    private AmazonSNSClient amazonSNSClient;



    @Override
    public void subscribe(String email) {
        SubscribeRequest request = new SubscribeRequest(arn,"email", email);
        amazonSNSClient.subscribe(request);
    }

    @Override
    public void unsubscribe(String arn) {
        UnsubscribeRequest request = new UnsubscribeRequest(arn);
        amazonSNSClient.unsubscribe(request);
    }

    @Override
    public void publishMessage() {

    }

    @Override
    public void publishMessage(String message) {
        PublishRequest request = new PublishRequest(arn, message, "message");
        amazonSNSClient.publish(request);
    }
}
