package com.abhi.microservices.limitsservice.controller;

import com.abhi.microservices.limitsservice.beans.LimitConfiguration;
import com.abhi.microservices.limitsservice.configuration.LimitPropertiesConfig;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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

    @GetMapping("/hystrix-example")
    @HystrixCommand(fallbackMethod = "getLimitsFromConfigFallbackMethod")
    public LimitConfiguration faultToleranceUsingHystrix(){
        throw new RuntimeException("Service not available!!"); // Logic that may cause the runtime exception due to the failure of calling external service
    }

    public LimitConfiguration getLimitsFromConfigFallbackMethod(){
        return new LimitConfiguration(1000, 10); // default configuration in case of failure of the service
    }


}
