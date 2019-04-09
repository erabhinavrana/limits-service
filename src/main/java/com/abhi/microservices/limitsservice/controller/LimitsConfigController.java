package com.abhi.microservices.limitsservice.controller;

import com.abhi.microservices.limitsservice.beans.LimitConfiguration;
import com.abhi.microservices.limitsservice.configuration.LimitPropertiesConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Abhinav on 4/1/2019.
 */
@RestController
public class LimitsConfigController {

    @Autowired
    private LimitPropertiesConfig limitPropertiesConfig;

    @GetMapping("/limits")
    public LimitConfiguration getLimitsFromConfig(){
        return new LimitConfiguration(limitPropertiesConfig.getMaximum(), limitPropertiesConfig.getMinimum());
    }
}
