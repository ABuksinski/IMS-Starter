package com.qa.ims.persistence.domain;

public class Order {
	private Long order_id;
	private Long customer_id;

	public Order(Long order_id, Long customer_id) {
		this.setOrder_id(order_id);
		this.setCustomer_id(customer_id);
	}

	public Order(Long id, String firstName, String surname) {
		this.setOrder_id(order_id);
		this.setCustomer_id(customer_id);
	}

	public Long getOrder_id() {
		return order_id;
	}

	public void setOrder_id(Long order_id) {
		this.order_id = order_id;
	}

	public Long getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(Long customer_id) {
		this.customer_id = customer_id;
	}
}
