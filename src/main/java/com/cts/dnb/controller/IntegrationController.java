package com.cts.dnb.controller;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class IntegrationController {

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping(path = "/integration/{number}", produces = "application/json")
	public String integration(@PathVariable String number) throws Exception {

		return "RESULT: " + dunsMatch(number);
	}

	public String generateToken() throws Exception {

		String basicToken = "Basic clQ1QUdYakE3cnJjangyQmRKYzZRajJyTkxLcTNvNFQ6bXBYTzhqMTd6UmtsME54Rg==";
		String tokenURL = "https://tst.plus.dnb.com/v2/token";
		// String grantValue = "{\"grant_type\" : \"client_credentials\"}";
		Map<String, String> grantValue = new HashMap<String, String>();
		grantValue.put("grant_type", "client_credentials");
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", basicToken);
		headers.set("Content-Type", "application/json");
		HttpEntity<Map<String, String>> requestEntity = new HttpEntity<Map<String, String>>(grantValue, headers);

		return this.restTemplate.exchange(tokenURL, HttpMethod.POST, requestEntity, String.class).getBody();

	}

	public String dunsMatch(String number) throws Exception {

		String accessTokenValue = generateToken();
		JSONParser parser = new JSONParser();
		JSONObject objToken = (JSONObject) parser.parse(accessTokenValue);
		String accessToken = (String) objToken.get("access_token");

		String tokenURL = "https://tst.plus.dnb.com/v1/match/cleanseMatch?duns=" + number;
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", "Bearer " + accessToken);
		HttpEntity<String> requestEntity = new HttpEntity<String>("parameters", headers);
		ResponseEntity<String> result = this.restTemplate.exchange(tokenURL, HttpMethod.GET, requestEntity,
				String.class);
		return result.getBody();

	}

	@Bean
	public RestTemplate rest() {
		return new RestTemplate();
	}

}
