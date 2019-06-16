package com.stackabuse.synchronizedExample;

public class SynchronizedBlockExample {

	public void printNumbers() {
		
		System.out.println("Starting to print Numbers for " + Thread.currentThread().getName());
		
		synchronized (this) {
			for (int i = 0; i < 5; i++) {
				System.out.println(Thread.currentThread().getName() + " " + i);
			}
		}
		
		System.out.println("Completed printing Numbers for " + Thread.currentThread().getName());
	}
}

class ThreadOne extends Thread {

	SynchronizedBlockExample synchronizedBlockExample;
	
	public ThreadOne(SynchronizedBlockExample synchronizedBlockExample) {
		this.synchronizedBlockExample = synchronizedBlockExample;
	}

	@Override
	public void run() {
		synchronizedBlockExample.printNumbers();
	}
}

class ThreadTwo extends Thread {

	SynchronizedBlockExample synchronizedBlockExample;
	
	public ThreadTwo(SynchronizedBlockExample synchronizedBlockExample) {
		this.synchronizedBlockExample = synchronizedBlockExample;
	}

	@Override
	public void run() {
		synchronizedBlockExample.printNumbers();
	}
}