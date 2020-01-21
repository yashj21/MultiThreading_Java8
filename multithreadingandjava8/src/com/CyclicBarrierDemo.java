package com;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
class ServiceTest implements Runnable{

	private String name;
	private int delay;
	private CyclicBarrier latch;
	 
	
	public ServiceTest(String name, int delay, CyclicBarrier latch) {
		this.name = name;
		this.delay = delay;
		this.latch = latch;
	}



	@Override
	public void run() {
		System.out.println(this.name + "starting");
		try {
			Thread.sleep(delay);
			latch.await();
			System.out.println(this.name + "completed");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
		}
	}
	
}

public class CyclicBarrierDemo {
		public static void main(String[] args) {

		CyclicBarrier barrier = new CyclicBarrier(5, new Runnable() {

			@Override
			public void run() {
				System.out.println("Barrier reached");
			}
		});
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		for (int i = 0; i < 15; i++) {
			executorService.execute(new ServiceTest("Order" + i, (i+1)*1000, barrier));
		}
	}

}
