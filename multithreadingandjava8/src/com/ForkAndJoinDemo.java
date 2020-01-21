package com;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;
import java.util.stream.IntStream;

public class ForkAndJoinDemo extends RecursiveTask<Integer>{

	private int [] data;
	
	
	public ForkAndJoinDemo(int[] data) {
		this.data = data;
	}

	public static void main(String[] args) {

		int [] numbers = new int [] {1,2,3,4,5,6,7,8,9,10};
		ForkJoinPool forkJoinPool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
		int result = forkJoinPool.invoke(new ForkAndJoinDemo(numbers));
		
		System.out.println("Result : "+ result );
	}

	@Override
	protected Integer compute() {

		int size = data.length;
		if(size>=2) {
			ForkAndJoinDemo left = new ForkAndJoinDemo(Arrays.copyOfRange(data, 0, size/2));
			ForkAndJoinDemo right = new ForkAndJoinDemo(Arrays.copyOfRange(data, size/2,size ));
			left.fork();
			right.fork();
			
			
			return Integer.sum(left.join(), right.join());
		}
		else {
		return IntStream.of(data).sum();	
		}
	}

}
