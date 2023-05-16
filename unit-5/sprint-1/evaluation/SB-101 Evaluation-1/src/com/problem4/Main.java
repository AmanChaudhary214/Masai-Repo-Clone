package com.problem4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
	
	public static int sum = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Integer> voterList = new ArrayList<>();
		
		voterList.add(22);
		voterList.add(24);
		voterList.add(26);
		voterList.add(28);
		voterList.add(30);
		voterList.add(32);
		voterList.add(34);
		voterList.add(16);
		voterList.add(28);
		voterList.add(20);
		
		Collections.sort(voterList, (a,b) -> {
			return a.compareTo(b);
		});
		

//		1. Check if the age of every voter is more than or equal to 18, if yes then display "You all can cast your vote" otherwise display "Some or none will cast vote"

		if(voterList.indexOf(0)<18) {
			System.out.println("Some or none will cast vote");
		}
		else {
			System.out.println("You all can cast your vote");
		}
		
		
//		2. Print distinct age of all voters
		System.out.println("======distinct age of all voters======");
		Map<Integer, Integer> map = new HashMap<>();
		voterList.forEach(element -> {
			if (map.containsKey(element) ) {
				map.put(element, map.get(element)+1);
			}
			else {
				map.put(element, 1);
			}
		});
		
		for(Map.Entry<Integer, Integer> element : map.entrySet()) {
			System.out.println(element.getKey()+" ");
		}

		
//		3. print age of 6th youngest to 8th youngest voters (total 3 members) in ascending order
		System.out.println("======age of 6th youngest to 8th youngest voters======");
		for (int i=5; i<8; i++) {
			System.out.println(voterList.get(i));
		}

		
//		4. print addition of age of all voters
		System.out.println("======addition of age of all voters======");
		voterList.forEach(element -> {
			Main.sum = sum + element;
		});
		System.out.println(sum);
		
//		5. State true or false:
		
//		5.1 The BinaryOperator interface is a subinterface of the Function interface such that both are SAM interfaces.
		System.out.println(false);
		
//		5.2 The BiConsumer interface is a subinterface of the Consumer interface such that both are SAM interfaces.
		System.out.println(false);
	}

}
