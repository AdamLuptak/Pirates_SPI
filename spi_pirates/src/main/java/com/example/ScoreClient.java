package com.example;

import bwl.wsdl.BwlResult;
import bwl.wsdl.GetBwl;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import score.wsdl.GetScore;
import score.wsdl.Score;
import score.wsdl.ScoreCollection;

/**
 * Created by adam on 1.5.2016.
 */
public class ScoreClient extends WebServiceGatewaySupport {

    public ScoreCollection getRequestScore(String zipCode) {

        GetScore request = new GetScore();
        request.setId("customer_A");
        request.setType("customer");


//        Object o  = null;
//        try {
//            o =  getWebServiceTemplate()
//                    .marshalSendAndReceive(
//                            "http://localhost:8088",
//                            request,
//                            new SoapActionCallback("http://localhost:8088"));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


        Object myType = ((javax.xml.bind.JAXBElement) getWebServiceTemplate().marshalSendAndReceive(request)).getValue();

        return (ScoreCollection) myType;
    }
}
