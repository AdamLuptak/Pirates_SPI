package com.example;


import io.spring.guides.gs_producing_web_service.GetSpiRequest;
import io.spring.guides.gs_producing_web_service.GetSpiResponse;
import io.spring.guides.gs_producing_web_service.ResultType;
import io.spring.guides.gs_producing_web_service.ResultValueType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.Arrays;

@Endpoint
public class SpiEndpoint {
	private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";
	private static final Logger logger = LoggerFactory.getLogger(SpiEndpoint.class);

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getSpiRequest")
	@ResponsePayload
	public GetSpiResponse getSpi(@RequestPayload GetSpiRequest request) {
		logger.info(Arrays.toString(request.getFunction().toArray()));

		GetSpiResponse response = new GetSpiResponse();
		ResultType results = new ResultType();
		results.setFunctionRef(request.getFunction().get(0).getName());

		ResultValueType resultType = new ResultValueType();
		resultType.setName(request.getFunction().get(0).getParameters().getParameter().get(0).getName());
		resultType.setValue(request.getFunction().get(0).getParameters().getParameter().get(0).getValue());
		ResultValueType resultType1 = new ResultValueType();
		resultType1.setName(request.getFunction().get(0).getParameters().getParameter().get(1).getName());
		resultType1.setValue(request.getFunction().get(0).getParameters().getParameter().get(1).getValue());

		results.getResultValue().add(resultType);
		results.getResultValue().add(resultType1);

		response.getResult().add(results);

		return response;
	}
}
