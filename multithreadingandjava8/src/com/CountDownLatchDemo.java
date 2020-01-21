package com;

import java.util.concurrent.CountDownLatch;

class Service implements Runnable{

	private String name;
	private int delay;
	private CountDownLatch latch;
	
	 
	
	public Service(String name, int delay, CountDownLatch latch) {
		this.name = name;
		this.delay = delay;
		this.latch = latch;
	}



	@Override
	public void run() {
		System.out.println(this.name + "starting");
		try {
			Thread.sleep(delay);
			latch.countDown();
			latch.await();//waits for all other threads to reach here then complete all together
			System.out.println(this.name + "completed");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}

public class CountDownLatchDemo {

	public static void main(String[] args) {
		CountDownLatch latch = new CountDownLatch(3);
		Thread t1 = new Thread (new Service("DB Service",2000,latch));
		Thread t2 = new Thread (new Service("Email Service",4000,latch));
		Thread t3 = new Thread (new Service("Message Service",3000,latch));
		
		t1.start();t2.start();t3.start();
		
		try {
			latch.await();//wait for the latches to get completed to come here then execute further
			System.out.println("CountDownLatchDemo.main(): completed...");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	
	
	}

}
