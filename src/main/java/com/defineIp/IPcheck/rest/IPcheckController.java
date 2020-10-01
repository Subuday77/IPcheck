package com.defineIp.IPcheck.rest;

import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.defineIp.IPcheck.beans.Result;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/request")
public class IPcheckController {
	@Autowired
	HttpServletRequest servletRequest;
	@Autowired
	Result result;

	String resultString = "There is nothing to show";

	@RequestMapping("/send")
	public ResponseEntity<?> getPost(HttpServletRequest request) {

		result.setProtocol(request.getProtocol());
		result.setRequestType(request.getMethod());
		result.setRemoteAddress(getClientIpAddress(request));
		System.out.println(result.getProtocol() + " " + result.getRequestType() + " request:\n" + request
				+ "\nCame from IP:\n" + result.getRemoteAddress());
		return new ResponseEntity<Result>(result, HttpStatus.OK);

	}

	public String getClientIpAddress(HttpServletRequest request) {
		String xForwardedForHeader = servletRequest.getHeader("X-Forwarded-For");
		if (xForwardedForHeader == null) {
			return request.getRemoteAddr();
		} else {
			return new StringTokenizer(xForwardedForHeader, ",").nextToken().trim();
		}
	}

	@PostMapping("/post")
	public void postRequest(@RequestBody String request) {
		
		String hash = servletRequest.getHeader("hash");
		System.out.println("Hash: " + hash);
		System.out.println("Request body: " + request);
		resultString = "Hash: " + hash + "\n" + "Request body: " + request;
		
	}

	@GetMapping("/getresult")
	public ResponseEntity<?> getResult() {
		return new ResponseEntity<String>(resultString, HttpStatus.OK);
	}

}
