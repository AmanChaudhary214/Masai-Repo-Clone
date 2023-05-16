package com.assignment.day12;

public interface Stack {
	
	void push(int element) throws OverflowException;
	
	int pop() throws UnderflowException;
	
	int peek() throws UnderflowException;
	
	static String displayStackElements(int stack[]) {
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<stack.length; i++) {
			
			sb.append(stack[i] + ", ");
		}
		return sb.toString();	
	}
}
