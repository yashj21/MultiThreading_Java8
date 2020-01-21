package com;

import java.util.ArrayList;
import java.util.List;

public class Box <T extends Number>{
 
	List<T> data;

	public T getData() {
		return (T) data;
	}

	public void setData(ArrayList<T> data) {
		this.data = data;
		
	}
	@ClassInfo(author = test.OK) 
	static void  addData(ArrayList<Number> test) {
		test.add(new Integer(1));
	}
	public static void main(String[] args) {
		Box obj = new Box();//In this T becomes an object this is called raw type
		//obj.setData("2");
		System.out.println("Data: "+obj.getData());
		//addData(new ArrayList<Integer>());
		Box<Integer> iBox = new Box<>();
		//iBox.setData(new Integer(25));
		//System.out.println("Data: " + (Number)iBox.getData());
	}
}