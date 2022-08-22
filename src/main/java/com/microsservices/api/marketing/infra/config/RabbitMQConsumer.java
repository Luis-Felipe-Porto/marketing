package com.microsservices.api.marketing.infra.config;

import com.microsservices.api.marketing.domain.Lead;
import com.microsservices.api.marketing.infra.config.utils.RabbitMQConstantes;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQConsumer {

    @RabbitListener(queues = RabbitMQConstantes.FILA_MARKETING)
    private void consumidor(Lead mensagem){
        System.out.println(mensagem);
        System.out.println("---------Lendo Mensagem do RabbitMQ----------");
    }
}
