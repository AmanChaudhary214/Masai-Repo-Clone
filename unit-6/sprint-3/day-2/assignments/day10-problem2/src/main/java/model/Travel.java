package model;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Travel {

	@Autowired
//	@Qualifier(value = "car")
	private Car vehicle;
	

	@PostConstruct
	public void init() {
		System.out.println("Travel class initialized");
	}

	@PreDestroy
	public void destroy() {
		System.out.println("Travel class destroyed");
	}

	public void startJourney() {
		vehicle.vehicleMethod();
	}
	
}
