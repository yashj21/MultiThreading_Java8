package com;

public class App implements Simple,Complex {

	@Override
	public void doTask(int x,int y) {
		System.out.println("App.doTask()");
	}

	@Override
	public void process() {
		Complex.super.process();
	}

	public static void main(String[] args) {
		Complex obj = new App();
		obj.process();
	}

	

	
	
	/*@Override
	public void process() {
		System.out.println("App.process()");
		Simple.super.process();
	}*/
}
