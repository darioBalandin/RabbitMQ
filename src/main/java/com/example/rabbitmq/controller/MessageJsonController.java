package com.example.rabbitmq.controller;


import com.example.rabbitmq.dto.User;
import com.example.rabbitmq.publisher.RabbitMQJsonProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class MessageJsonController {

    private RabbitMQJsonProducer rabbitMQJsonProducer;

    public MessageJsonController(RabbitMQJsonProducer rabbitMQJsonProducer) {
        this.rabbitMQJsonProducer = rabbitMQJsonProducer;
    }


    @PostMapping("/publish")
    public ResponseEntity<String> sendMessage(@RequestBody User user) {
        rabbitMQJsonProducer.sendMessage(user);
        return ResponseEntity.ok("JSON Message sent to the RabbitMQ Successfully");
    }
}
