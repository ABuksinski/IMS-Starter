package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

public class OrderItemTest {
	private OrderItem test = new OrderItem(1L, 1L, 5L, "Adrian", "Buksinski", "mug", 10.0);

	@Test
	public void testEquals() {
		EqualsVerifier.simple().forClass(OrderItem.class).verify();
	}

	@Test
	public void testGetOrderId() {
		assertEquals(1L, test.getOrderId(), 0);

	}

	@Test
	public void testGetItemId() {
		assertEquals(1L, test.getItemId(), 0);

	}

	@Test
	public void testGetQuantity() {
		assertEquals(5L, test.getQuantity(), 0);

	}

	@Test
	public void testGetFirstName() {
		assertEquals("Adrian", test.getFirstName());

	}

	@Test
	public void testGetSurname() {
		assertEquals("Buksinski", test.getSurname());

	}

	@Test
	public void testItemName() {
		assertEquals("mug", test.getItemName());
	}

	@Test
	public void testItemValue() {
		assertEquals(Double.valueOf(10), test.getItemValue());
	}

	@Test
	public void testGetCost() {
		assertEquals(Double.valueOf(50), test.getCost());

	}

	@SuppressWarnings("unused")
	@Test
	public void testConstructor() {
		OrderItem cons1 = new OrderItem(2L, 5L);
		OrderItem cons2 = new OrderItem(30.0);
		OrderItem cons3 = new OrderItem(3L, 20L, 5L);
		OrderItem cons4 = new OrderItem(6L, 4L, 20L, "John", "Smith", "Carpet", 100.0);
	}

	@Test
	public void testToString() {
		assertEquals("Order ID: 1, First Name: Adrian, Surname: Buksinski, Product: mug, Quantity: 5", test.toString());
	}

	@Test
	public void testToStringCost() {
		assertEquals("Total Cost: 50.0", test.toString());
	}
}
