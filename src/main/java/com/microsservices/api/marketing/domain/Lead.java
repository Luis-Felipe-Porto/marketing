package com.microsservices.api.marketing.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Lead {
    @Id
    private String codigo;
    private String nome;
    @Indexed(unique = true)
    private String email;
    private LeadStatus leadStatus;

    public void convert(){
        this.leadStatus = LeadStatus.CUSTOMER;
    }

    public Lead(String nome, String email, LeadStatus leadStatus) {
        this.nome = nome;
        this.email = email;
        this.leadStatus = leadStatus;
    }

    public Lead() {
    }
}
