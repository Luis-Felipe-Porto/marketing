package com.microsservices.api.marketing.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document
@Data
public class Lead implements Serializable {
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
    public Lead(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public Lead() {
    }
}
