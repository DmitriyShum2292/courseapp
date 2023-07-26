package com.example.courseapp.service;


import org.springframework.stereotype.Service;

@Service
public interface SQSService {

    public void sendMessageToQueue(String message);

//    public void loadMessageFromSQS(String message);
}
