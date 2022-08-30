package com.microsservices.api.marketing.infra.config;

import com.microsservices.api.marketing.application.LeadSevice;
import com.microsservices.api.marketing.domain.Lead;
import com.microsservices.api.marketing.infra.config.utils.LoggerMarketingApplication;
import com.microsservices.api.marketing.infra.config.utils.RabbitMQConstantes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQConsumer {
    private final LeadSevice leadSevice;


    public RabbitMQConsumer(LeadSevice leadSevice) {
        this.leadSevice = leadSevice;
    }

    @RabbitListener(queues = RabbitMQConstantes.FILA_FINANCEIRO)
    private void consumidor(String emailLead){
        if(!emailLead.isBlank()){
            leadSevice.converterLead(emailLead);
            LoggerMarketingApplication.logger.info("Lendo Mensagem do RabbitMQ");
            LoggerMarketingApplication.logger.info("Convertendo Lead "+emailLead);
        }else{
            LoggerMarketingApplication.logger.info("Lead Empty"+emailLead);
        }

    }
}
