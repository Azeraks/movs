package com.azera.movs.exercise_05.adapter.controller.in.messages;

import com.azera.movs.exercise_05.application.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RabbitMQInputMessaging {

    
    @RabbitListener(queues = "#{queue.name}")
    public void receive(String message) {
        System.out.println("RabbitMQInputMessaging::receive -> " + message);
    }


}
