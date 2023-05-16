package com.masai.pack_3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Product> list = new ArrayList<>();
		
		list.add(new Product(1, "TiffinBox", 10, 4500));
		list.add(new Product(2, "Vase", 20, 10000));
		list.add(new Product(3, "Bags", 15, 12000));
		list.add(new Product(4, "Charger", 5, 4000));
		list.add(new Product(5, "Mouse", 12, 8000));
		
		Collections.sort(list, (Product a, Product b) -> {
			if (a.getPrice() < b.getPrice()) {
				return 1;
			}
			else if (a.getPrice() > b.getPrice()) {
				return -1;
			}
			else return 0;
		});
		
		for (Product element : list) {
			System.out.println(element);
		}
	}

}
