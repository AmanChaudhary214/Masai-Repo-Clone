package com.assignment.day05;
import java.util.Scanner;

//Take you name input, convert the same to the array and the find total vowels and consonants on you name.

public class MyName {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your name: ");
		String name = sc.nextLine();
		name = name.toLowerCase();
		
		int count = 0;
		int count2 = 0;
		int count3 = 0;
		char ch[] = name.toCharArray();
		for (int i=0; i<name.length(); i++) {
			if (ch[i]=='a' || ch[i]=='e' || ch[i]=='i' || ch[i]=='o' || ch[i]=='u') {
				count++;
			}
			else if (ch[i]==' ') {
				count2++;
			}
		}
		count3 = name.length()-count-count2;
		System.out.println("Vowel_Count : "+count);
		System.out.println("Consonant_Count : "+count3);
	}
}