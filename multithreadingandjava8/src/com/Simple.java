package com;

public interface Simple {
	public void doTask(int x, int y);
	
	default void process() {
		System.out.println("test123");
	}
}
