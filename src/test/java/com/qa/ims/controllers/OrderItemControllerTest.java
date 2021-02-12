package com.qa.ims.controllers;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.controller.OrderItemController;
import com.qa.ims.persistence.dao.OrderItemDAO;
import com.qa.ims.persistence.domain.OrderItem;
import com.qa.ims.utils.Utils;

@RunWith(MockitoJUnitRunner.class)
public class OrderItemControllerTest {
	@Mock
	private Utils utils;

	@Mock
	private OrderItemDAO dao;

	@InjectMocks
	private OrderItemController controller;

//	@Test
//	public void testCreate() {
//		final Long itemId = 4L, quantity = 15L, orderId = 1L;
//		final OrderItem created = new OrderItem(itemId, quantity, orderId);
//
//		Mockito.when(utils.getLong()).thenReturn(itemId, quantity, orderId);
//		Mockito.when(dao.create(Mockito.any(OrderItem.class))).thenReturn(created);
//
//		assertEquals(created, controller.create());
//
//		Mockito.verify(utils, Mockito.times(3)).getLong();
//		Mockito.verify(dao, Mockito.times(1)).create(created);
//	}

	@Test
	public void testReadAll() {
		List<OrderItem> orderitems = new ArrayList<>();
		orderitems.add(new OrderItem(3L, 10L, 3L));

		Mockito.when(dao.readAll()).thenReturn(orderitems);

		assertEquals(orderitems, controller.readAll());

		Mockito.verify(dao, Mockito.times(1)).readAll();
	}

	@Test
	public void testUpdate() {
		OrderItem updated = new OrderItem(3L, 10L, 3L);

		Mockito.when(this.utils.getLong()).thenReturn(3L, 10L, 3L);

		Mockito.when(this.dao.update(updated)).thenReturn(updated);

		assertEquals(updated, this.controller.update());

		Mockito.verify(this.utils, Mockito.times(3)).getLong();
		Mockito.verify(this.dao, Mockito.times(1)).update(updated);
	}

	@Test
	public void testDelete() {
		final long ID = 1L;

		Mockito.when(utils.getLong()).thenReturn(ID);
//		Mockito.when(dao.delete(ID)).thenReturn(1);

		assertEquals(0, this.controller.delete());

		Mockito.verify(utils, Mockito.times(2)).getLong();
//		Mockito.verify(dao, Mockito.times(1)).deleteProduct(1L,1L);
	}
}
