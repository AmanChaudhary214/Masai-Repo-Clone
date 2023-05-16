package com.problem1;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Demo d = Integer::parseInt;
		int x = d.convetStringToNumber("18");
		System.out.println(x/2);
	}

}
