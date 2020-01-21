package com;

public class ThreadLocalDemo implements Runnable{

	private double value;
	private ThreadLocal<Double> threadLocal = new ThreadLocal<>();
	public static void main(String[] args) {
		ThreadLocalDemo obj = new ThreadLocalDemo();
		Thread t1 = new Thread(obj);
		Thread t2 = new Thread(obj);
		
		t1.start();t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("THreadLocalDemo.main():"+obj.value);
	}

	@Override
	public void run() {
		double rnd = Math.random() *100;
		System.out.println("TheradLcoaDmeo.run()");
		this.value=rnd;
		threadLocal.set(rnd);
	}
	private void printValue() {
		System.out.println("Values for "+this.value);
		System.out.println("Values for threadlocal "+threadLocal.get());
	}
}
