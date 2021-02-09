package com.qa.ims.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.dao.OrderItemDAO;
import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.persistence.domain.OrderItem;
import com.qa.ims.utils.DBUtils;
import com.qa.ims.utils.Utils;

public class OrderController implements CrudController<Order> {

	public static final Logger LOGGER = LogManager.getLogger();

	private OrderDAO orderDAO;
	private Utils utils = new Utils();
	private OrderItemDAO orderitemDAO = new OrderItemDAO();
	private OrderItemController orderitemController = new OrderItemController(orderitemDAO, utils);

	public OrderController(OrderDAO orderDAO, Utils utils) {
		super();
		this.orderDAO = orderDAO;
		this.utils = utils;
	}

	@Override
	public List<Order> readAll() {
		// TODO Auto-generated method stub
		List<Order> orders = orderDAO.readAll();
		for (Order order : orders) {
			LOGGER.info(order);
		}
		orderitemController.readAll();
		return orders;
		
		

	}

	@Override
	public Order create() {
		// TODO Auto-generated method stub
		LOGGER.info("Please enter your Customer ID");
		Long customer_id = utils.getLong();
		Order order = orderDAO.create(new Order(customer_id));
		LOGGER.info("Order " + order.getOrder_id() + " created");
		LOGGER.info("Would you like to add  item to an order? /r/n Yes or No");
		String adding = utils.getString();
		if (adding.equalsIgnoreCase("yes")) {
			orderitemController.createNew();
			return order;
		} else {
			return null;
		}

	}

	@Override
	public Order update() {
		// TODO Auto-generated method stub
		LOGGER.info("Please enter your Customer ID");
		Long customer_id = utils.getLong();
		LOGGER.info(orderDAO.readOrders(customer_id));
		LOGGER.info("Would you like to add a new Product or update existing order?");
		LOGGER.info("NEW or EXISTING");
		String method = utils.getString();
		if (method.equalsIgnoreCase("NEW")) {
			orderitemController.createNew();
			return null;
		} else if (method.equalsIgnoreCase("EXISTING")) {
			orderitemController.readAll();
			orderitemController.update();
			return null;
		} else {
			return null;
		}

	}

	@Override
	public int delete() {
		// TODO Auto-generated method stub
		LOGGER.info("Please enter the id of the order you would like to delete");
		Long order_id = utils.getLong();
		return orderDAO.delete(order_id);
	}

}
