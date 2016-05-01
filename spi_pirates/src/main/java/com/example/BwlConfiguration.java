package com.example;

import com.example.BwlClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

/**
 * Created by adam on 29.4.2016.
 */
@Configuration
public class BwlConfiguration {

    @Bean
    public Jaxb2Marshaller marshallerBwl() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPaths("bwl.wsdl");
        return marshaller;
    }

    @Bean
    public BwlClient blwClient(Jaxb2Marshaller marshallerBwl) {
        BwlClient client = new BwlClient();
        client.setDefaultUri("http://localhost:8088");
        client.setMarshaller(marshallerBwl);
        client.setUnmarshaller(marshallerBwl);
        return client;
    }

}
