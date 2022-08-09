package com.microsservices.api.marketing.application;

import com.microsservices.api.marketing.domain.Lead;
import com.microsservices.api.marketing.infra.repository.LeadRepository;
import org.springframework.stereotype.Service;

@Service
public class LeadSevice {

    private final LeadRepository leadRepository;

    public LeadSevice(LeadRepository leadRepository) {
        this.leadRepository = leadRepository;
    }

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
