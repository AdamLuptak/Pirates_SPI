package com.example;

import bwl.wsdl.BwlResult;
import io.spring.guides.gs_producing_web_service.GetSpiResponse;
import io.spring.guides.gs_producing_web_service.ResultType;
import io.spring.guides.gs_producing_web_service.ResultValueType;
import org.springframework.stereotype.Component;
import score.wsdl.Score;
import score.wsdl.ScoreCollection;

import java.lang.reflect.Field;
import java.util.List;

/**
 * Created by adam on 1.5.2016.
 */
@Component
public class ResponseBuilder {

    private GetSpiResponse response;


    public ResponseBuilder() {
        this.response = new GetSpiResponse();

    }

    public GetSpiResponse addResultBwl(String functioRef, BwlResult bwlResponse) {
        ResultType results = new ResultType();
        results.setFunctionRef(functioRef);
        ResultValueType resultType = new ResultValueType();
        resultType.setName(bwlResponse.getScore().get(0).getClass().getDeclaredFields()[0].getName());
        resultType.setValue(String.valueOf(bwlResponse.getScore().get(0).isIsInBwl()));
        results.getResultValue().add(resultType);
        response.getResult().add(results);
        return response;
    }

    public void resetResponse() {
        this.response = null;
    }

    public void addResultScore(String functioRef, Score scoreCollection) {
        ResultType results = new ResultType();
        results.setFunctionRef(functioRef);
        List<ResultValueType> resultValues = results.getResultValue();

       for (Field field : scoreCollection.getClass().getDeclaredFields()) {
            ResultValueType resultType = new ResultValueType();
            switch (field.getName()) {
                case "id":
                    resultType.setName(field.getName());
                    resultType.setValue(scoreCollection.getId());
                    break;
                case "type":
                    resultType.setName(field.getName());
                    resultType.setValue(scoreCollection.getType());
                    break;
                case "score":
                    resultType.setName(field.getName());
                    resultType.setValue(scoreCollection.getScore());
                    break;
                case "value":
                    resultType.setName(field.getName());
                    resultType.setValue(String.valueOf(scoreCollection.getValue()));
                    break;
            }
            resultValues.add(resultType);
        }
        response.getResult().add(results);
    }

    public GetSpiResponse getResponse() {
        return this.response;
    }
}
