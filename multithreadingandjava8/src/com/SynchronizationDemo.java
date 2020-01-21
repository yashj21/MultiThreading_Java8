package com;

public class SynchronizationDemo implements Runnable{

	private static Counter counter = new Counter();
	
	public static void main(String[] args) {
		Thread t1= new Thread (new SynchronizationDemo());
		t1.start();
		Thread t2 = new Thread(new SynchronizationDemo());
		t2.start();
		
		/*try {
			t1.join();
			t2.join();

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
*/	System.out.println("Count:" + counter.getCount());	
	}

	@Override
	public void run() {

		for (int i = 0; i < 5; i++) {
			counter.incrementCount();;
		}
	}

}
