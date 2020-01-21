package com;

import java.util.concurrent.Semaphore;

import org.omg.PortableServer.THREAD_POLICY_ID;

public class SemaphoreDemo implements Runnable {

	private Semaphore semaphore = new Semaphore(2);
	
	public static void main(String[] args) {

	SemaphoreDemo semaphoreDemo = new SemaphoreDemo();
	Thread t1 = new Thread(semaphoreDemo);
	t1.start();
	Thread t2 = new Thread(semaphoreDemo);
	t2.start();
	Thread t3 = new Thread(semaphoreDemo);
	t3.start();
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " starting");
			try {
				semaphore.acquire();
				System.out.println(Thread.currentThread().getName() + " acquired semaphore...");
				Thread.sleep(5000);
				semaphore.release();
				System.out.println(Thread.currentThread().getName() + " releases semaphore...");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	}

}
