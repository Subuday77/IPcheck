package com.defineIp.IPcheck.beans;

import org.springframework.stereotype.Component;

@Component
public class Result {

	private String result;

	public Result() {
		// TODO Auto-generated constructor stub
	}

	public Result(String result) {
		this.result = result;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

}
