package com.microsservices.api.marketing.infra;

import com.microsservices.api.marketing.domain.Lead;

public interface LeadRepository{

    Lead findByEmail(String email);

    void save(Lead lead);
}
