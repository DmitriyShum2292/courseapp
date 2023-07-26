package com.example.courseapp.controller;

import com.amazonaws.services.lambda.model.InvokeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.amazonaws.services.lambda.AWSLambda;

@RestController
@RequestMapping("/api/v1/lambda")
public class LambdaController {

    private final AWSLambda awsLambda;
    @Value("${cloud.aws.function-arn}")
    private String functionARN;

    @Autowired
    public LambdaController(AWSLambda awsLambda) {
        this.awsLambda = awsLambda;
    }

    @GetMapping("/action")
    public ResponseEntity<Object> lambdaAction () {
        try {
            InvokeRequest invokeRequest = new InvokeRequest()
                    .withFunctionName(functionARN)
                    .withPayload("{\"detail-type\": \"AWP application\"}");
            awsLambda.invoke(invokeRequest);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
