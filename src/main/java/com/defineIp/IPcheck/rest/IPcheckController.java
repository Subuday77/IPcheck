package com.defineIp.IPcheck.rest;

import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/request")
public class IPcheckController {
	@Autowired
	HttpServletRequest servletRequest;

	@RequestMapping("/send")
	public ResponseEntity<?> getPost(HttpServletRequest request) {
		String type = request.getMethod();
		System.out.println(type + " request:\n" + request + "\nCame from IP:\n" + getClientIpAddress(request));
		return new ResponseEntity<String>(
				type + " request:\n" + request + "\nCame from IP:\n" + getClientIpAddress(request), HttpStatus.OK);

	}

	public String getClientIpAddress(HttpServletRequest request) {
		String xForwardedForHeader = servletRequest.getHeader("X-Forwarded-For");
		if (xForwardedForHeader == null) {
			return request.getRemoteAddr();
		} else {
			return new StringTokenizer(xForwardedForHeader, ",").nextToken().trim();
		}
	}

}
