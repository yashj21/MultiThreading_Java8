package com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

interface Test{
	int compute(int x, int y);
	
}
public class MethodReferences {
	public static int add (int x, int y) {
		
		return x+y;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		example2();
	}

	public static void example2() {
		Test test = (x,y)-> x+y;
		// but with method reference suppose we already had an add method an we wanted to pass the handle of that function to Test class instead of writing the function we can do this by using method references
		test = MethodReferences::add;
		//MethodReferences::add this gives an handle to the method which would be placed inside compute if not used this we would have to call add method inside the interface's compute method then return that value basically we are avoiding the use of Wrappers here
		List<Integer> number= Arrays.asList(1,2,3,4,5);
		number.forEach(System.out::println);//since printlne behaves like consumers which only accepts value and returns void
		//Supplier<List<String>> supplier = () -> new ArrayList<String>();//rather than doing this  
		Supplier<List<String>> supplier = ArrayList<String >::new;//this is a supplier same as arraylist constructor behaves as a supplier the get method takes no argument and returns the object type T  
	}
}
