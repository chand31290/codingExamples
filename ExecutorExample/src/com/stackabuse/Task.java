package com.stackabuse;

import java.util.concurrent.Callable;

public class Task implements Callable<String> {

	private String message;

	public Task(String message) {
		this.message = message;
	}

	@Override
	public String call() throws Exception {
		return "Hello " + message + "!";
	}

}
