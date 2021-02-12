package com.qa.ims.persistence.domain;
	import static org.junit.Assert.assertEquals;

	import org.junit.Test;

	import nl.jqno.equalsverifier.EqualsVerifier;
public class ItemTest {
	
		Long itemId = 2L;
		Double itemValue = 10.00;
			private Item test = new Item( itemId,  "name" , itemValue) ;


		@Test
		public void testEquals() {
			EqualsVerifier.simple().forClass(Item.class).verify();
		}
			
			@Test
			public void testGetitemValue() {
				assertEquals(Double.valueOf(10), test.getItemValue());
			
		}
			@Test
			public void testGetItemName() {
				assertEquals("name", test.getItemName());
			
		}
			@Test
			public void testGetItemId() {
				assertEquals(2L, test.getItemId(),0);

	}
			@SuppressWarnings("unused")
			@Test 
			public  void testConstructor() {
				Item it1 = new Item ("Mug" , 5.00);
				Item it2 = new Item (1231L, "Cup" , 10.00);
			}
			@Test 
			public void testToString( ) {
				assertEquals( "Item id: 2 Item name: name Price: 10.0",test.toString());
			}
	}


