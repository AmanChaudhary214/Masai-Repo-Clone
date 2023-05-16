package walmart;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Products {

	@Id
	private int productID;
	private String name;
	private Double price; 
	private String category;
	private int stockQuantity;
}
