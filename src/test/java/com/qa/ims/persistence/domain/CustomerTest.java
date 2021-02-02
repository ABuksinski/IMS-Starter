package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

public class CustomerTest  {
	Long Id = 2L;
		private Customer test = new Customer( Id,  "name" , "surname") ;


	@Test
	public void testEquals() {
		EqualsVerifier.simple().forClass(Customer.class).verify();
	}
		
		@Test
		public void testGetSurname() {
			assertEquals("surname", test.getSurname());
		
	}
		@Test
		public void testGetFirstName() {
			assertEquals("name", test.getFirstName());
		
	}
		@Test
		public void testGetId() {
			assertEquals(2L, test.getId(),0);

}
		@SuppressWarnings("unused")
		@Test 
		public  void testConstructor() {
			Customer cust1 = new Customer ("Adrian" , "Buksinski");
			Customer cust2 = new Customer (1231L, "John" , "Smith");
		}
		@Test 
		public void testToString( ) {
			assertEquals( "id:2 first name:name surname:surname" ,test.toString());
		}
}
