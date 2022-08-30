package com.microsservices.api.marketing.application;

import com.microsservices.api.marketing.domain.Lead;
import com.microsservices.api.marketing.infra.repository.LeadRepository;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class LeadSevice {

    private final LeadRepository leadRepository;

    private static Logger logger = LoggerFactory.getLogger(LeadSevice.class);

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
        Lead LeadbyEmail = leadRepository.findByEmail(email);
        if(LeadbyEmail != null){
            LeadbyEmail.convert();
            leadRepository.save(LeadbyEmail);
        }else {
            logger.error(email+ " not found in service marketing");
        }

    }
}
