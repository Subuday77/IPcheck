package com.defineIp.IPcheck.beans;

import org.springframework.stereotype.Component;

@Component
public class Result {

	private String protocol;
	private String requestType;
	private String remoteAddress;
	

	public Result() {
		// TODO Auto-generated constructor stub
	}

	public Result(String protocol, String requestType, String remoteAddress) {
		this.setProtocol(protocol);
		this.requestType = requestType;
		this.remoteAddress = remoteAddress;
	}

	public String getProtocol() {
		return protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	public String getRequestType() {
		return requestType;
	}

	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}

	public String getRemoteAddress() {
		return remoteAddress;
	}

	public void setRemoteAddress(String remoteAddress) {
		this.remoteAddress = remoteAddress;
	}

}
