package com.microsservices.api.marketing.infra.config.utils;

import com.microsservices.api.marketing.MarketingApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoggerMarketingApplication {

    public static Logger logger = LoggerFactory.getLogger(MarketingApplication.class);

}
