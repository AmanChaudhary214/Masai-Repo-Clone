package Salesforce;

public class Service {
	
	Demo demo;

	public Service(Demo demo) {
		this.demo = demo;
	}
	
	public void demoMethod() {
		demo.calledMethod();
	}

}
