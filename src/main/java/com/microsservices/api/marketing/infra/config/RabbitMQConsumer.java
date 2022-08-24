package com.microsservices.api.marketing.infra.config;

import com.microsservices.api.marketing.application.LeadSevice;
import com.microsservices.api.marketing.domain.Lead;
import com.microsservices.api.marketing.infra.config.utils.RabbitMQConstantes;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQConsumer {
    private final LeadSevice leadSevice;

    public RabbitMQConsumer(LeadSevice leadSevice) {
        this.leadSevice = leadSevice;
    }

//    @RabbitListener(queues = RabbitMQConstantes.FILA_FINANCEIRO)
//    private void consumidor(Lead Lead){
//        leadSevice.converterLead(Lead);
//        System.out.println("---------Lendo Mensagem do RabbitMQ----------");
//        System.out.println("---------Convertendo Lead----------");
//    }
}
