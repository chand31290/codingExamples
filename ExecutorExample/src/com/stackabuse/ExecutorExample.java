package com.stackabuse;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorExample {
	public static void main(String[] args) {

		Task task = new Task("World");

		ExecutorService executorService = Executors.newFixedThreadPool(4);
		Future<String> result = executorService.submit(task);

		try {
			System.out.println(result.get());
		} catch (InterruptedException | ExecutionException e) {
			System.out.println("Error occured while executingthe submitted task");
			e.printStackTrace();
		}

		executorService.shutdown();
	}
}
