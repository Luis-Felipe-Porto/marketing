package com.microsservices.api.marketing.application;

import com.microsservices.api.marketing.domain.Lead;
import com.microsservices.api.marketing.infra.LeadRepository;

public class LeadSevice {

    private LeadRepository leadRepository;

    public void salvar(Lead lead){
        leadRepository.save(lead);
    }
    public Lead buscarPorEmail(String email){
        return new Lead();
    }
    public void converterLead(String email){
        Lead lead = buscarPorEmail(email);
        lead.convert();
        leadRepository.save(lead);
    }
}
