package com.microsservices.api.marketing.response;

import com.microsservices.api.marketing.application.LeadSevice;
import com.microsservices.api.marketing.domain.Lead;
import com.microsservices.api.marketing.infra.config.utils.RabbitMQConstantes;
import com.microsservices.api.marketing.infra.service.RabbitmqService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/marketing")
public record LeadResponse(LeadSevice leadSevice, RabbitmqService rabbitmqService) {


    @GetMapping
    public Page<Lead> getLead(@PageableDefault(size = 10) Pageable pageable){
        return leadSevice.buscarLeads(pageable);
    }
    @PostMapping
    public Lead postLead(@RequestBody Lead lead){
        rabbitmqService.enviaMensagem(RabbitMQConstantes.FILA_MARKETING,lead);
        return leadSevice.salvar(lead);
    }
    @GetMapping("/buscarPorEmail")
    public Lead getLeadPorEmail(@PathVariable String email){
        return leadSevice.buscarPorEmail(email);
    }
}
