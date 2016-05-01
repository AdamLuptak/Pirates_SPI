package com.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;


@Configuration
public class ScoreConfiguration {

    @Bean
    public Jaxb2Marshaller marshallerScore() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPaths("score.wsdl");
        return marshaller;
    }

    @Bean
    public ScoreClient scoreClient(Jaxb2Marshaller marshallerScore) {
        ScoreClient client = new ScoreClient();
        client.setDefaultUri("http://localhost:8089");
        client.setMarshaller(marshallerScore);
        client.setUnmarshaller(marshallerScore);
        return client;
    }

}
