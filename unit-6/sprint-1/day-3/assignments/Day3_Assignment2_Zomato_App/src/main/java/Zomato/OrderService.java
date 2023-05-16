package Zomato;

public class OrderService {
	
	RestaurantService restService;

	public void setRestService(RestaurantService restService) {
		this.restService = restService;
	}

	public String orderDetails() {
		
		System.out.println(restService.restaurantDetails());
		return "Order placed and will be delivered in 20 minutes.";
	}
}
