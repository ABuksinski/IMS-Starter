package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.dao.OrderItemDAO;

import com.qa.ims.persistence.domain.Order;

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
		LOGGER.info("Would you like to see the total  cost of your order?");
		LOGGER.info("Yes or No");
		String cost = utils.getString();
		if (cost.equalsIgnoreCase("yes")) {
			LOGGER.info("Enter the Id of your  order:");
			Long order_id = utils.getLong();
			LOGGER.info(orderitemDAO.calculateOrderCost(order_id).toStringCost());
			return null;
		} else if (cost.equalsIgnoreCase("no")) {
			return orders;

		} else {
		}
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
		LOGGER.info("Please enter your Customer ID");
		Long customer_id = utils.getLong();
		LOGGER.info(orderDAO.readOrders(customer_id));
		LOGGER.info("Would you like to delete a product or a whole order?");
		LOGGER.info("product or order");
		String method = utils.getString();
		if (method.equalsIgnoreCase("product")) {
			orderitemController.delete();
			return 0;
		} else if (method.equalsIgnoreCase("order")) {
			LOGGER.info("Please eneter the ID of an order that you wish to  delete");
			Long order_id = utils.getLong();
			orderDAO.delete(order_id);
			return 0;
		}

		else {
			return 0;
		}
	}
}
