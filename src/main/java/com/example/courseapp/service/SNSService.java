package com.example.courseapp.service;

import org.springframework.stereotype.Service;

@Service
public interface SNSService {

    void subscribe (String email);
    void unsubscribe (String email);

    void publishMessage();

    void publishMessage(String message);
}
