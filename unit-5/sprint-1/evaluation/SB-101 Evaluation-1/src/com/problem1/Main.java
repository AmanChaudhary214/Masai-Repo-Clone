package com.problem1;

import java.util.function.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Function<String, Product> f = prod -> {
			String[] arr = prod.split(",");
			return new Product(Integer.parseInt(arr[0]), arr[1], Double.parseDouble(arr[2]), Integer.parseInt(arr[3]));
		};
		System.out.println(f.apply("1,Pen,20.00,100"));
		
		Supplier<Product> s = () -> new Product(10, "Laptop", 50000.00, 1);
		Product pr = s.get();
		System.out.println(pr);
		
		Consumer<Product> c = p1 -> System.out.println(p1.toString());
		c.accept(new Product(15, "Mobile", 20000.00, 1));
		
		Predicate<Product> p = p1 -> p1.getQuantity()<5 ? true:false;
		boolean res = p.test(new Product(15, "Mobile", 20000.00, 2));
		System.out.println(res);
	}

}
