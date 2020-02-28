package br.com.alura.forum.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloController {

	@RequestMapping("/")
	public String hello() {
		String url = "http://localhost:8090/auth";
		RestTemplate restTemplate = new RestTemplate();
	    
	    Map<String, String> map = new HashMap<>();
	    map.put("nome", "admin");
	    map.put("senha", "admin@10");

	    ResponseEntity<Token> response = restTemplate.postForEntity(url, map, Token.class);
		
	    System.out.println(response.getBody().getToken());

//		return restTemplate.postForObject("http://192.168.152.193:8080/auth", entity, String.class);
	    return null;
	}
}
class Token {
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	private String token;
	private String tipo;
	
	public Token() {
	}
	
	public Token(String token, String tipo) {
		super();
		this.token = token;
		this.tipo = tipo;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
}