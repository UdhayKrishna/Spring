
package com.cts.dnb.controller;
/*
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ServiceController {

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping(path = "/integration/{number}", produces = "application/json")
	public String integration(@PathVariable String number) {
		
		String tokenURL = "http://localhost:8080/dunsMatch/";
		String basicToken = "Basic clQ1QUdYakE3cnJjangyQmRKYzZRajJyTkxLcTNvNFQ6bXBYTzhqMTd6UmtsME54Rg==";
		
		return "";
	}
	
	
	@PostMapping(path = "/generateToken", consumes = "application/json", produces = "application/json")
	public String generateToken(@RequestHeader(name = "Authorization", required = true) String bearerToken,
			@RequestHeader(name = "Content-Type", required = false, defaultValue = "application/json") String contentType,
			@RequestBody Map<String, String> grantValue) throws Exception {
		
		
		String tokenURL = "https://tst.plus.dnb.com/v2/token";
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", bearerToken);
		headers.set("Content-Type", contentType);
		HttpEntity<Map<String, String>> requestEntity = new HttpEntity<Map<String, String>>(grantValue, headers);
		
		return this.restTemplate.exchange(tokenURL, HttpMethod.POST, requestEntity, String.class).getBody();

	}

	
	@GetMapping(path = "/dunsMatch/{number}", produces = "application/json")
	public String dunsMatch(@PathVariable String number) throws Exception {

		String tokenURL = "https://tst.plus.dnb.com/v1/match/cleanseMatch?duns=" + number;
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", "Bearer " + "69Hv0yjwh4Nwo3N1bKlTLhowCVaI");
		HttpEntity<String> requestEntity = new HttpEntity<String>("parameters", headers);
		ResponseEntity<String> result =  this.restTemplate.exchange(tokenURL, HttpMethod.GET, requestEntity, String.class);
		return result.getBody();

	}
	
	
	@Bean
	public RestTemplate rest() {
		return new RestTemplate();
	}
	}
*/

