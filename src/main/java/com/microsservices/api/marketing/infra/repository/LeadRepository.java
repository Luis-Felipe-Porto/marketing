package com.microsservices.api.marketing.infra.repository;

import com.microsservices.api.marketing.domain.Lead;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LeadRepository extends MongoRepository<Lead,String> {

    Lead findByEmail(String email);


}
