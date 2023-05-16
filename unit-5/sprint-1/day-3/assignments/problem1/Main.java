package com.problem1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Exception ex = new ArrayIndexOutOfBoundsException("Not a Valid Index");
		
		Supplier<String> s = ex::toString;
		System.out.println(s.get());
		
		List<String> list = new ArrayList<>();
		list.add("Aman");
		Predicate<String> p = list::add;
		
		Map<Integer, String> map = new LinkedHashMap<>();
		BiFunction<Integer, String, String> f1 = map::putIfAbsent;
		String str = f1.apply(10, "Ten");
		String str1 = f1.apply(20, "Twenty");
		System.out.println(str + "\n" + str1);
		
		Function<String, StringBuilder> f2 = new StringBuilder()::append;
		System.out.println(f2.apply("Good thing fall apart"));
		
		Consumer<String> c = n -> System.out.println("Hello " + n.toUpperCase());
		c.accept("Aman");
		
	}

}
