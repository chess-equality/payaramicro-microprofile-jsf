package org.chessequality.payaramicro.microprofile.jsf.primefaces.control;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import org.chessequality.payaramicro.microprofile.jsf.primefaces.entity.Customer;

@FacesConverter(value = "customerConverter", managed = true)
public class CustomerConverter implements Converter<Customer> {

	@Inject
	private CustomerService customerService;

	@Override
	public String getAsString(FacesContext context, UIComponent component, Customer customer) {

		if (customer == null) {
			return "";
		}

		return customer.getCustomerId();
	}

	@Override
	public Customer getAsObject(FacesContext context, UIComponent component, String value) {
		if (value == null || value.isEmpty()) {
			return null;
		}

		return customerService.findByCustomerId(value);
	}

}