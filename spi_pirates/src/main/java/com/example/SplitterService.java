package com.example;

import bwl.wsdl.ParameterType;
import bwl.wsdl.ParametersType;
import io.spring.guides.gs_producing_web_service.FunctionType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.Future;

/**
 * Created by adam on 1.5.2016.
 */
@Service
public class SplitterService {

    private static final Logger logger = LoggerFactory.getLogger(SpiEndpoint.class);

    @Autowired
    BwlClient bwlClient;
    @Autowired
    ScoreClient scoreClient;


    @Async
    public Future<Object> procesRequest(String service, FunctionType paramteres) throws InterruptedException {

        Object reponse = null;

        logger.info("Startig service " + service);
         if(service.equalsIgnoreCase("bwl")){

             reponse =  bwlClient.getRequestBwl(paramteres);
         }else if(service.equalsIgnoreCase("score")){
             reponse =  scoreClient.getRequestScore("daco");
         }


//        System.out.println("Looking up " + user);
//        User results = restTemplate.getForObject("https://api.github.com/users/" + user, User.class);
        // Artificial delay of 1s for demonstration purposes
//        Thread.sleep(1000L);
        return new AsyncResult<Object>(reponse);
    }

}
