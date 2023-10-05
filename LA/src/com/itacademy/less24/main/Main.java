package com.itacademy.less24.main;

public class Main {
	public static void main(String[] args) {
		Box<Integer> ob1 = new Box<Integer>();
		Box<Double> ob2 = new Box<Double>();
		Box<String> ob3 = new Box<String>();
		
		ob1.setOb1(1);
		System.out.println(ob1.getOb1().toString());
	
	}
}
