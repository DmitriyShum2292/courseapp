package com.example.courseapp.controller;

import com.example.courseapp.service.SNSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/sns")
public class SNSController {

    @Autowired
    private SNSService snsService;

    @GetMapping("/subscribe/{email}")
    public ResponseEntity subscribe (@PathVariable String email) {
        snsService.subscribe(email);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/unsubscribe/{arn}")
    public ResponseEntity unsubscribe (@PathVariable String arn) {
        snsService.unsubscribe(arn);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/publish")
    public ResponseEntity publish () {
        snsService.publishMessage();
        return new ResponseEntity(HttpStatus.OK);
    }
}
