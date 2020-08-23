package com.defineIp.IPcheck.rest;

import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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

	@RequestMapping("/send")
	public ResponseEntity<?> getPost(HttpServletRequest request) {
		result.setRequestType(request.getMethod());
		result.setRemoteAddress(getClientIpAddress(request));
		System.out.println(result.getRequestType() + " request:\n" + request + "\nCame from IP:\n" + result.getRemoteAddress());
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

}
