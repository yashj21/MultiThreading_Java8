package com;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class CompleteableFutureDemo {

	public static void main(String[] args) {

		CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync((Supplier<Integer>) ()->{
		
			System.out.println(Thread.currentThread().getName() + "start task" );
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return 200;
		}).thenApply((Function<Integer, Integer>)(Integer result)->{
			return result*1000;
		}); //using get makes it blocking so using these methods we can process the elements we get from future by using thenapply or accept and print something rather than blocking execution of the ongoing thread using get 
		completableFuture.thenAccept((Consumer<Integer>) (Integer result)->{
			System.out.println("result");
		});
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
