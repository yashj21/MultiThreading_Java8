package com;

public class Counter {

	private int count = 0;
	Object mutex = new Object();
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	//public synchronized void incrementCount()  
	public void incrementCount()  { //synchronize places locks always on the object and not on method
		System.out.println(Thread.currentThread().getName()+"incrementing count" + this.count);
		//this.count++;
		//synchronized (this) { //never set on primitive types always on the object
		synchronized (mutex) {
		
		int temp = this.count;
			temp++;
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(this.count == 5 && Thread.currentThread().getName().equals("Thread-1")) {
				System.out.println(Thread.currentThread().getName() + "calling wait");
				try {
				mutex.wait();
				}
				 catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			if(this.count == 6) {
				mutex.notifyAll();
			}
			this.count = temp;
				
		}
		System.out.println(Thread.currentThread().getName()+"incremented count" + this.count);
		
	}
	
}
