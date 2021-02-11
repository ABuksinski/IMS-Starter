package com.qa.ims.persistence.domain;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

public class OrderTest {
	Long Id = 1L;
	private Order test = new Order( Id,  1L ) ;


@Test
public void testEquals() {
	EqualsVerifier.simple().forClass(Order.class).verify();
}
	
	@Test
	public void testGetOrderId() {
		assertEquals(1L, test.getOrderId(),0);
	
}

	@Test
	public void testGetCustomerId() {
		assertEquals(1L, test.getCustomerId(),0);

}
	@SuppressWarnings("unused")
	@Test 
	public  void testConstructor() {
		Order cons1 = new Order (2L);
		Order cons2 = new Order (2L,2L);
	}
	@Test 
	public void testToString( ) {
		assertEquals( "Customer ID: 1,  Order ID: 1" ,test.toString());
	}
}
