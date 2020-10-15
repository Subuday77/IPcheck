package com.defineIp.IPcheck.beans;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component
public class RequestList {
	
	public ArrayList<String> requests = new ArrayList<String>();

	public RequestList(ArrayList<String> requests) {
		this.requests = requests;
	}

	public RequestList() {
		// TODO Auto-generated constructor stub
	}

	public ArrayList<String> getRequests() {
		return requests;
	}

	public void setRequests(ArrayList<String> requests) {
		this.requests = requests;
	}

	@Override
	public String toString() {
		return "RequestList [requests=" + requests + "]";
	}
	
	

}
