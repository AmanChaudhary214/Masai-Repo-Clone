package com.assignment.day12;

public class MyStack implements Stack{
	private int stack[];
	private int top;
	final static int MAX_SIZE = 5;
	
	MyStack(){
		stack = new int[MAX_SIZE];
	    top = -1;
	}

	@Override
	public void push(int element) throws OverflowException {
		// TODO Auto-generated method stub
		if (top<MAX_SIZE-1) {
			top++;
			stack[top] = element;
		}
		else {
			throw new OverflowException("Stack is Full");
		}
	}

	@Override
	public int pop() throws UnderflowException {
		// TODO Auto-generated method stub
		if (top>=0) {
			int num = stack[top];
			top--;
			return num;
		}
		else {
			throw new UnderflowException("Stack is Empty");
		}
	}

	@Override
	public int peek() throws UnderflowException {
		// TODO Auto-generated method stub
		if (top>=0) {
			return stack[top];
		}
		else {
			throw new UnderflowException("Stack is Empty");
		}
	}
	@Override 
	public String toString(){
		if(top>=0) {
			return Stack.displayStackElements(stack);
		}
		else {
			return "Stack is Empty";
		}
	}
}
