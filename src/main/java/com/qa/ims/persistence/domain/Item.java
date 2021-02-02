package com.qa.ims.persistence.domain;

public class Item {
	private Long item_id;
	private String item_name;
	private Double item_value;

	public Item(String item_name, Double item_value) {
		this.setItem_name(item_name);
		this.setItem_value(item_value);
	}

	public Item(Long item_id, String item_name, Double item_value) {
		this.setItem_id(item_id);
		this.setItem_name(item_name);
		this.setItem_value(item_value);

	}

	public Long getItem_id() {
		return item_id;
	}

	public void setItem_id(Long item_id) {
		this.item_id = item_id;
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

	@Override
	public String toString() {
		return ("Item id: " + item_id + " Item name: " + item_name + " Price: " + item_value);

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((item_name == null) ? 0 : item_name.hashCode());
		result = prime * result + ((item_id == null) ? 0 : item_id.hashCode());
		result = prime * result + ((item_value == null) ? 0 : item_value.hashCode());
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
		Item other = (Item) obj;
		if (getItem_name() == null) {
			if (other.getItem_name() != null)
				return false;
		} else if (!getItem_name().equals(other.getItem_name()))
			return false;
		if (item_id == null) {
			if (other.item_id != null)
				return false;
		} else if (!item_id.equals(other.item_id))
			return false;
		if (item_value == null) {
			if (other.item_value != null)
				return false;
		} else if (!item_value.equals(other.item_value))
			return false;
		return true;
	}
}