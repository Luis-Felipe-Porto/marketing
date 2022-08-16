package com.microsservices.api.marketing.infra.config;

import com.microsservices.api.marketing.domain.Lead;
import com.microsservices.api.marketing.infra.config.utils.RabbitMQConstantes;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

//@Component
//public class RabbitMQConsumer {
//
//    @RabbitListener(queues = RabbitMQConstantes.FILA_CURSO)
//    private void consumidor(Lead lead){
//        System.out.println(lead.getCodigo());
//    }
//}
