package com.microsservices.api.marketing.response;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/marketing")
public record LeadResponse() {

    @GetMapping
    public String getLead(){
        return "getLead";
    }
    @PostMapping
    public String postLead(){

        return "posLead";
    }
}
