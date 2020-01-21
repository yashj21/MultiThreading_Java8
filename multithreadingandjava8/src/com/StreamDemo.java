package com;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamDemo {

	public static void main(String[] args) {

		
		List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9);
		numbers.stream().
		filter((num) -> num>3).
		map(num-> num*num);
		
		/*.forEach(System.out::println)*/;;
	

	}

}
