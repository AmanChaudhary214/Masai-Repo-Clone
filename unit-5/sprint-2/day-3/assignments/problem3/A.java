package com.problem3;

class A{
	___________ ____________ void fun(){		//----- (1), (2)
		//code
	}
}

class B implements Runnable{
	A a = new A();
	
	public void run(){
		synchronized(__){		//---- (3)
			//code
		}
		
		//say wait method is called somewhere for this thread
		notify();		//---- (4)
	}
}

//(1) Which keyword is to be used to make sure that only one thread from an object of class A should enter in the method fun?
//(2) Which keyword is to be used to make sure that only one thread from an class A should enter in the method fun?
//(3) What is is written here to make sure that only one thread from an class A should enter in the synchronized block?
//(4) Is that code okay? If no, suggest improvement?