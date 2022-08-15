package com.microsservices.api.marketing;

import com.microsservices.api.marketing.domain.Lead;
import com.microsservices.api.marketing.domain.LeadStatus;
import com.microsservices.api.marketing.infra.repository.LeadRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MarketingApplication {

    public static void main(String[] args) {
        SpringApplication.run(MarketingApplication.class, args);
    }

//    @Bean
//    CommandLineRunner commandLineRunner (LeadRepository leadRepository){
//        return args -> {
//            Lead lead = new Lead(
//                    "Felipe",
//                    "luis.felipe@email.com",
//                    LeadStatus.CANCELED
//            );
//            leadRepository.insert(lead);
//        };
//    }
}
