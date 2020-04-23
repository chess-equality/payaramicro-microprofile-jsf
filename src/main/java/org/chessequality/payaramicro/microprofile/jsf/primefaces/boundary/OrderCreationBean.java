package org.chessequality.payaramicro.microprofile.jsf.primefaces.boundary;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.chessequality.payaramicro.microprofile.jsf.primefaces.control.CustomerService;
import org.chessequality.payaramicro.microprofile.jsf.primefaces.control.OrderService;
import org.chessequality.payaramicro.microprofile.jsf.primefaces.entity.Customer;
import org.chessequality.payaramicro.microprofile.jsf.primefaces.entity.Order;

@Named
@RequestScoped
public class OrderCreationBean {

	@NotEmpty
	private String taxId;

	@NotNull
	private Customer selectedCustomer;

	@NotEmpty
	private String selectedProduct;
	private boolean expressDelivery;

	@NotNull
	@Positive
	private Integer amount;

	@NotNull
	private Date orderDate;

	private List<Customer> availableCustomers;

	@Inject
	private CustomerService customerService;

	@Inject
	private OrderService orderService;

	@PostConstruct
	public void init() {
		availableCustomers = customerService.getCustomers();
	}

	public String createOder() {
		Order order = new Order(taxId, selectedCustomer.getCustomerId(), selectedProduct, amount, orderDate,
				expressDelivery);
		orderService.addOrder(order);

		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Successful", "Successfully created order:  " + order.getOrderId()));
		context.getExternalContext().getFlash().setKeepMessages(true);

		return "/createOrder.xhtml?faces-redirect=true";
	}

	public List<Customer> getAvailableCustomers() {
		return availableCustomers;
	}

	public String getTaxId() {
		return taxId;
	}

	public void setTaxId(String taxId) {
		this.taxId = taxId;
	}

	public Customer getSelectedCustomer() {
		return selectedCustomer;
	}

	public void setSelectedCustomer(Customer selectedCustomer) {
		this.selectedCustomer = selectedCustomer;
	}

	public String getSelectedProduct() {
		return selectedProduct;
	}

	public void setSelectedProduct(String selectedProduct) {
		this.selectedProduct = selectedProduct;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public boolean isExpressDelivery() {
		return expressDelivery;
	}

	public void setExpressDelivery(boolean expressDelivery) {
		this.expressDelivery = expressDelivery;
	}

}
