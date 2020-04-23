package org.chessequality.payaramicro.microprofile.jsf.primefaces.control;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Schedule;
import javax.ejb.Singleton;

import org.chessequality.payaramicro.microprofile.jsf.primefaces.entity.Order;

@Singleton
public class OrderService {

	private List<Order> orders;

	@PostConstruct
	public void init() {
		this.orders = createDefaultOrder();
	}

	@Schedule(hour = "*", minute = "*/10", persistent = false)
	public void resetCustomers() {
		this.orders = createDefaultOrder();
	}

	private List<Order> createDefaultOrder() {
		List<Order> result = new ArrayList<>();
		result.add(new Order("999-123456789", "DUMMY-DUMMY", "Laptop", 4, new Date(), false));
		return result;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void addOrder(Order order) {
		this.orders.add(order);
	}

}
