package com;

public class DemoThread extends Thread{
	
	int x;int y;
	public void example1() {
		Simple simple = (int x, int y)-> {
			final int z = 5; 
			int	a;
			this.x= x;
			Simple simple1 = (int m, int n)->{
				
			};
			
		};
	}
	@Override
	public void run() {
		MainThread.printThreadInfo();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Demo Thread over");//didnt execute on bg thread container closed of main stack
	}
	public static void main(String[] args) {
	MainThread.printThreadInfo();
	
	DemoThread demoThread = new DemoThread();
	demoThread.setName("DemoThread");
	demoThread.setPriority(10);
	demoThread.setDaemon(false);//set it to false so that the sysoutprint works
	demoThread.start();//maps to the os level for creating new thread
	
	Thread thread = new Thread(() ->{
		String s ="abcd";
		Thread thread1 =new Thread(()->{//first class means hold an object and return an object
			int x = 5;
		});
		MainThread.printThreadInfo();
		
		
	});
	thread.setName("Lamda thread");
	thread.start();
	System.out.println("Main Completes`");
}
}
//interrupts are mechanism to send a message or event from one thread to another since no facility to stop now so now this makes the thread decide if it wants to stop this is one use case of interrupt