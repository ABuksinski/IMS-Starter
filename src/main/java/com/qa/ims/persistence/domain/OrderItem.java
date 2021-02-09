package com.qa.ims.persistence.domain;

public class OrderItem {
	private Long order_id;
	private Long item_id;
	private Long quantity;
	private String first_name;
	private String surname;
	private String item_name;
	private Double item_value;
	private Double cost;

	public OrderItem(Long item_id, Long quantity) {
		this.setItem_id(item_id);
		this.setQuantity(quantity);
	}
	public OrderItem(Double cost) {
		this.setCost(cost);
	}

	public OrderItem(Long item_id, Long quantity, Long order_id) {
		this.setItem_id(item_id);
		this.setQuantity(quantity);
		this.setOrder_id(order_id);
	}

	public OrderItem(Long order_id, Long item_id, Long quantity, String first_name, String surname, String item_name,
			Double item_value) {
		this.setItem_id(item_id);
		this.setQuantity(quantity);
		this.setOrder_id(order_id);
		this.setFirst_name(first_name);
		this.setSurname(surname);
		this.setItem_name(item_name);
		this.setItem_value(item_value);

		this.setCost(cost);
	}

	public Long getOrder_id() {
		return order_id;
	}

	public void setOrder_id(Long order_id) {
		this.order_id = order_id;
	}

	public Long getItem_id() {
		return item_id;
	}

	public void setItem_id(Long item_id) {
		this.item_id = item_id;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public Double getItem_value() {
		return item_value;
	}

	public void setItem_value(Double item_value) {
		this.item_value = item_value;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return ("Order ID: " + order_id + ", First Name: " + first_name + ", Surname: " + surname + ", Product: "
				+ item_name + ", Quantity: " + quantity);
	}
	public String toStringCost() {
		return ("Total Cost: " + cost);
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cost == null) ? 0 : cost.hashCode());
		result = prime * result + ((first_name == null) ? 0 : first_name.hashCode());
		result = prime * result + ((item_id == null) ? 0 : item_id.hashCode());
		result = prime * result + ((item_name == null) ? 0 : item_name.hashCode());
		result = prime * result + ((item_value == null) ? 0 : item_value.hashCode());
		result = prime * result + ((order_id == null) ? 0 : order_id.hashCode());
		result = prime * result + ((quantity == null) ? 0 : quantity.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItem other = (OrderItem) obj;
		if (cost == null) {
			if (other.cost != null)
				return false;
		} else if (!cost.equals(other.cost))
			return false;
		if (first_name == null) {
			if (other.first_name != null)
				return false;
		} else if (!first_name.equals(other.first_name))
			return false;
		if (item_id == null) {
			if (other.item_id != null)
				return false;
		} else if (!item_id.equals(other.item_id))
			return false;
		if (item_name == null) {
			if (other.item_name != null)
				return false;
		} else if (!item_name.equals(other.item_name))
			return false;
		if (item_value == null) {
			if (other.item_value != null)
				return false;
		} else if (!item_value.equals(other.item_value))
			return false;
		if (order_id == null) {
			if (other.order_id != null)
				return false;
		} else if (!order_id.equals(other.order_id))
			return false;
		if (quantity == null) {
			if (other.quantity != null)
				return false;
		} else if (!quantity.equals(other.quantity))
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		return true;
	}

}
