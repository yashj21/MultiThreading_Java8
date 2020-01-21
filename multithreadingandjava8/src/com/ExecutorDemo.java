package com;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class Task implements Runnable{

	private int taskId;
	
	public Task(int taskId) {
		this.taskId = taskId;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + "start task" + taskId);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + "completing task " + taskId);
	}
	
}



public class ExecutorDemo {

	
	
	public static void main(String[] args) {
		BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<>();
		ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 15, 30, TimeUnit.SECONDS, workQueue);//blocking queue means it waits for task in queue to gets completed 
		for (int i = 0; i < 10; i++) {
			executor.execute(new MyTask(i));
		}
		executor.shutdown();
		try {
			executor.awaitTermination(5000, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("ExecutorDemo.main() : executor shutdown");

	}

}
