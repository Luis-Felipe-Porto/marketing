package com.microsservices.api.marketing.application;

import com.microsservices.api.marketing.domain.Lead;
import com.microsservices.api.marketing.infra.repository.LeadRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

@Service
public class LeadSevice {

    private final LeadRepository leadRepository;



    public LeadSevice(LeadRepository leadRepository) {
        this.leadRepository = leadRepository;
    }

    public Lead salvar(Lead lead){
        return leadRepository.insert(lead);
    }
    public Page<Lead> buscarLeads(Pageable pageable){
        return leadRepository.findAll(pageable);
    }
    public Lead buscarPorEmail(String email){
        return leadRepository.findByEmail(email);
    }
    public void converterLead(String email){
        Lead lead = buscarPorEmail(email);
        lead.convert();
        leadRepository.insert(lead);
    }
}
