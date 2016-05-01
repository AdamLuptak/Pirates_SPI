package com.example;


import bwl.wsdl.BwlResult;
import bwl.wsdl.GetBwl;
import io.spring.guides.gs_producing_web_service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import score.wsdl.ScoreCollection;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;
import java.lang.reflect.Field;
import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Endpoint
public class SpiEndpoint extends WebServiceGatewaySupport {
    private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";
    private static final Logger logger = LoggerFactory.getLogger(SpiEndpoint.class);

    @Autowired
    BwlClient bwlClient;
    @Autowired
    ScoreClient scoreClient;
    @Autowired
    SplitterService splitterService;

    ResponseBuilder responseBuilder;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getSpiRequest")
    @ResponsePayload
    public GetSpiResponse getSpi(@RequestPayload GetSpiRequest request) throws InterruptedException, ExecutionException, JAXBException {

        Map<String,Future<Object>> reponses = new TreeMap<>();

        long start = System.currentTimeMillis();

        for (FunctionType function : request.getFunction()){
            reponses.put(function.getFunctionRef(), splitterService.procesRequest(function.getName(), function));
        }

        System.out.println("Every request is on separate thread");

        // Wait until they are all done
        while (!(reponses.get("bwl_1").isDone() && reponses.get("score_1").isDone() && reponses.get("bwl_1").isDone())) {
            System.out.println("Every request is on separate thread");
            Thread.sleep(1); //10-millisecond pause between each check
        }

        // Print results, including elapsed time
        System.out.println("Elapsed time: " + (System.currentTimeMillis() - start));

        ResponseBuilder responseBuilder = new ResponseBuilder();
        reponses.forEach((k,v) ->{
            if(k.contains("bwl")){
                try {
                    BwlResult bwlResult = (BwlResult) v.get();
                    responseBuilder.addResultBwl(k, bwlResult);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }else if(k.contains("score")){
                try {
                    ScoreCollection scoreCollection = (ScoreCollection) v.get();
                    responseBuilder.addResultScore(k, scoreCollection.getScore().get(0));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }

        });


//        JAXBContext jc = JAXBContext.newInstance(BwlResult.class);
//        Marshaller marshaller =   jc.createMarshaller();
//        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
//        marshaller.marshal(new JAXBElement<BwlResult>(new QName("uri","local"), BwlResult.class, bwlResult), System.out);

        GetSpiResponse response =responseBuilder.getResponse();
        return response;
    }
}
