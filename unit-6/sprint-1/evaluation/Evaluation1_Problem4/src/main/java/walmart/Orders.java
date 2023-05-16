package walmart;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Orders {

	@Id
	private int orderId;
	private String name;
	private LocalDate orderDate;
	private String orderStatus;
	
	@OneToOne
	private OrderDetails orderDetails;
	
	@OneToMany
	private List<Products> productList;

}
