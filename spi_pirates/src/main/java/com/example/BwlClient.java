package com.example;

import bwl.wsdl.BwlResult;
import bwl.wsdl.GetBwl;
import bwl.wsdl.ParameterType;
import bwl.wsdl.ParametersType;
import io.spring.guides.gs_producing_web_service.FunctionType;
import org.springframework.stereotype.Component;
import org.springframework.validation.ObjectError;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import java.util.List;

/**
 * Created by adam on 29.4.2016.
 */
public class BwlClient extends WebServiceGatewaySupport {

    public BwlResult getRequestBwl(FunctionType paramteres) {

        GetBwl request = new GetBwl();
        request.setId(paramteres.getParameters().getParameter().get(0).getValue());
        request.setType(paramteres.getParameters().getParameter().get(1).getValue());


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


         BwlResult myType = (BwlResult)((javax.xml.bind.JAXBElement) getWebServiceTemplate().marshalSendAndReceive(request)).getValue();

        return myType;
    }

}
