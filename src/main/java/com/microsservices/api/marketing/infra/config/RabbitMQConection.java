package com.microsservices.api.marketing.infra.config;

import com.microsservices.api.marketing.infra.config.utils.RabbitMQConstantes;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.stereotype.Component;


import javax.annotation.PostConstruct;

@Component
public class RabbitMQConection {
    private String NOME_EXCHANGE = "amq.direct";
    private AmqpAdmin amqpAdmin;

    public RabbitMQConection(AmqpAdmin amqpAdmin) {
        this.amqpAdmin = amqpAdmin;
    }

    private Queue fila(String nomeFila){
        return new Queue(nomeFila, true,false,false);
    }

    private DirectExchange trocaDireta(){
        return new DirectExchange(NOME_EXCHANGE);
    }
    /*
        Precisamos de um relaciomento para poder relacionar um excenhage
        a uma fila
     */
    private Binding relacionamento(Queue fila ,DirectExchange troca){
        return new Binding(fila.getName(),Binding.DestinationType.QUEUE,troca.getName(), fila.getName(), null);
    }
    @PostConstruct
    private void adiciona(){
        Queue filaMarketing = this.fila(RabbitMQConstantes.FILA_MARKETING);
        Queue filaCurso = this.fila(RabbitMQConstantes.FILA_CURSO);

        DirectExchange troca = this.trocaDireta();

        Binding ligacaoMarketing = this.relacionamento(filaMarketing, troca);
        Binding ligacaoCurso = this.relacionamento(filaCurso, troca);


        this.amqpAdmin.declareQueue(filaMarketing);
        this.amqpAdmin.declareQueue(filaCurso);

        this.amqpAdmin.declareExchange(troca);

        this.amqpAdmin.declareBinding(ligacaoMarketing);
        this.amqpAdmin.declareBinding(ligacaoCurso);

    }
}
