package com.microsservices.api.marketing.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Lead {
    @Id
    private String codigo;
    private String nome;
    private String email;
    private LeadStatus leadStatus;

    public void convert(){
        this.leadStatus = LeadStatus.CUSTOMER;
    }
}
