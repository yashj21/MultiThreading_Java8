package com;

public class MainThread {
 
	public static void printThreadInfo() {
		System.out.println("ID :"+ Thread.currentThread().getId());//currentThread() gives handle to current thread executing
		System.out.println("Nam :"+ Thread.currentThread().getName());
		System.out.println("prio :"+ Thread.currentThread().getPriority());
		System.out.println("state :"+ Thread.currentThread().getState());//runnable means it can run 
		System.out.println("thread grp:"+Thread.currentThread().getThreadGroup());//suspend directly all threads in a group, need not assign a group by default takes the parent who is creating it 
		System.out.println("is background:"+Thread.currentThread().isDaemon());//worker threads execute in background, so set daemon then how does completable future gets exited after main thread is over??
		
	
	}
	
public static void main(String[] args) {
	MainThread.printThreadInfo();
}
}
