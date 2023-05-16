package walmart;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Customers {

	@Id
	private int CustomerId;
	private String name;
	private String email; 
	private String address;
	private String phone;
	
	@OneToMany
	private List<Orders> orderList;
}
