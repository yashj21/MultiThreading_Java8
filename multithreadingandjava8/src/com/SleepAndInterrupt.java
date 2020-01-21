package com;

import java.io.File;

public class SleepAndInterrupt extends Thread{

	private int fileCount;
	
	private void watchFiles() {
		File file = new File("C:\\temp");
		String [] allFiles = file.list();
		if(fileCount!= allFiles.length) {
			System.out.println("Drctory changed with file count :" + allFiles.length);
			fileCount = allFiles.length;
		}
		else {
			System.out.println("No changes");
		}
	}
	
	@Override
	public void run() {
		while(true) {
			watchFiles();
			if(this.isInterrupted())
			{
				System.out.println("Thread interupted.....");
				break;
			}
				try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				//e.printStackTrace();
				System.out.println("Thread interuupt");
				break;
			
			}
		}

} 
	public static void main(String[] args)  {
		Thread thread  = new Thread(new SleepAndInterrupt());
		thread.start();
		
		try {
			thread.sleep(1111);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}// main thread will go to sleep not child thread it's as good as Thread.sleep java doesnt allow to call other thread to sleep
		thread.interrupt();// use this to interrupt another thread since you cannot make sleep another thread
		System.out.println("sleep and Interrupt main : completed");
		 try {
			thread.join();//wait for termination of this thread
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	
	}

}
