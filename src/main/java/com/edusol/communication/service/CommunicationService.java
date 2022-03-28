package com.edusol.communication.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.edusol.communication.model.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class CommunicationService {

	@Autowired
	private RestTemplate template;

	
	public List<User> getUsers() {

		//final String url = "http://localhost:8082/users";
		final String url = "http://user-service/users";

		HttpHeaders header = new HttpHeaders();
		header.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		HttpEntity<String> entity = new HttpEntity<String>(header);

		ResponseEntity<User[]> response = template.exchange(url, HttpMethod.GET, entity, User[].class);

		System.out.print(response.getBody().toString());

		List<User> users = Arrays.asList(response.getBody());

		return users;
	}

	@HystrixCommand(fallbackMethod = "showfallback")
	public String updateUser(User user) {

		final String url = "http://localhost:8082/users";

		HttpHeaders header = new HttpHeaders();
		header.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		HttpEntity<User> entity = new HttpEntity<User>(user, header);

		String response = template.exchange(url, HttpMethod.PUT, entity, String.class).getBody();

		return response;
	}

	public String showfallback(User user) {
		return "request failed. It takes too long time to response";
	}

	
	public String deleteUser(int id) {

		final String url = "http://localhost:8082/users/" + id;

		HttpHeaders header = new HttpHeaders();
		header.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		HttpEntity<String> entity = new HttpEntity<String>(header);

		String response = template.exchange(url, HttpMethod.DELETE, entity, String.class).getBody();

		return response;

	}

	
	public String addUser(User user) {

		final String url = "http://localhost:8082/users";

		HttpHeaders header = new HttpHeaders();
		header.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		HttpEntity<User> entity = new HttpEntity<User>(user, header);

		String response = template.exchange(url, HttpMethod.POST, entity, String.class).getBody();

		return response;
	}

	
	public List<User> getUserByCity(String city) {

		final String url = "http://localhost:8082/users/" + city;

		HttpHeaders header = new HttpHeaders();
		header.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		HttpEntity<String> entity = new HttpEntity<String>(header);

		ResponseEntity<User[]> response = template.exchange(url, HttpMethod.GET, entity, User[].class);

		System.out.print(response.getBody().toString());

		List<User> users = Arrays.asList(response.getBody());

		return users;
	}

	
	public List<User> getUserById(int id) {

		final String url = "http://localhost:8082/users/id/" + id;

		HttpHeaders header = new HttpHeaders();
		header.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		HttpEntity<String> entity = new HttpEntity<String>(header);

		ResponseEntity<User[]> response = template.exchange(url, HttpMethod.GET, entity, User[].class);

		System.out.print(response.getBody().toString());

		List<User> users = Arrays.asList(response.getBody());

		return users;
	}

	
	public List<User> getUserByEmail(String email) {

		final String url = "http://localhost:8082/users/email/" + email;

		HttpHeaders header = new HttpHeaders();
		header.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		HttpEntity<String> entity = new HttpEntity<String>(header);

		ResponseEntity<User[]> response = template.exchange(url, HttpMethod.GET, entity, User[].class);

		System.out.print(response.getBody().toString());

		List<User> users = Arrays.asList(response.getBody());

		return users;
	}

	
	public String deleteByCity(String city) {

		final String url = "http://localhost:8082/users/city/" + city;

		HttpHeaders header = new HttpHeaders();
		header.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		HttpEntity<String> entity = new HttpEntity<String>(header);

		String response = template.exchange(url, HttpMethod.DELETE, entity, String.class).getBody();

		return response;

	}

}
