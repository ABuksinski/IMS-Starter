package com.qa.ims.persistence.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.qa.ims.persistence.domain.OrderItem;
import com.qa.ims.utils.DBUtils;

public class OrderItemDAOExceptionTest {
	private final OrderItemDAO DAO = new OrderItemDAO();
	
	@Before
	public void setup() {
		DBUtils.connect("Fail");
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
	}

	@Test
	public void testCreateNew() {
		final OrderItem created = new OrderItem(1L, 1L, 1L);
	
		assertEquals(null, DAO.createNew(created,1L));
		
	}
	@Test
	public void testCreate() {
		final OrderItem created = new OrderItem(1L, 15L, 1L);
		assertEquals(null, DAO.create(created));
		
	}

	@Test
	public void testReadAll() {
		List<OrderItem> expected = new ArrayList<>();
		expected.add(new OrderItem(1L,1L, 10L, "jordan","harrison","cup",20.0));
	
		assertEquals(new ArrayList<>(), DAO.readAll());
	}

	@Test
	public void testReadLatest() {

		assertEquals(null, DAO.readLatest());
	}

	@Test
	public void testRead() {
		final long ID = 1L;
	
		assertEquals(null, DAO.read(ID));
	}

	@Test
	public void testUpdate() {
		final OrderItem updated = new OrderItem(1L, 1L, 10L);
	
		assertEquals(null, DAO.update(updated));

	}

	@Test
	public void testDelete() {
		
		assertEquals(0, DAO.delete(1));
	}
	
	@Test
	public void testDeleteProduct() {
		
		assertEquals(0, DAO.delete(1));
	}
	
	
	}


