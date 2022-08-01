package com.microsservices.api.marketing.domain;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Lead {
    private String nome;
    private String email;
    private LeadStatus leadStatus;

    public void convert(){
        this.leadStatus = LeadStatus.CUSTOMER;
    }
}
