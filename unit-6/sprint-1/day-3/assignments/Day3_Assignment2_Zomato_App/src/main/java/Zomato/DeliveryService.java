package Zomato;

public class DeliveryService {

	OrderService orderService;

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
	
	public void deliveryDetails() {
		System.out.println(orderService.orderDetails());
	}
}
