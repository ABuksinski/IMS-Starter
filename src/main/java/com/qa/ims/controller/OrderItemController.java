package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.OrderItemDAO;

import com.qa.ims.persistence.domain.OrderItem;
import com.qa.ims.utils.Utils;

public class OrderItemController implements CrudController<OrderItem> {

	public static final Logger LOGGER = LogManager.getLogger();

	private OrderItemDAO orderitemDAO;
	private Utils utils;

	public OrderItemController(OrderItemDAO orderitemDAO, Utils utils) {
		super();
		this.orderitemDAO = orderitemDAO;
		this.utils = utils;

	}

	@Override
	public List<OrderItem> readAll() {

		List<OrderItem> orderitems = orderitemDAO.readAll();
		for (OrderItem orderitem : orderitems) {
			LOGGER.info(orderitem);

		}

		return orderitems;
	}

	public OrderItem create(Long orderId) {
	

		boolean bOoLeAn = true;

		do {
			LOGGER.info("Please enter an ID of a Product you  wish to add");
			Long itemId = utils.getLong();
			LOGGER.info("Please enter the quantity");
			Long quantity = utils.getLong();

			OrderItem orderitem = orderitemDAO.create(new OrderItem(orderId,itemId, quantity));

			LOGGER.info("Item added");

			LOGGER.info("Would you like  to add another Product into the order \n YES or NO");
			String YN = utils.getString();
			if (YN.equalsIgnoreCase("yes")) {
				bOoLeAn = true;
				continue;
			}

			else {
				bOoLeAn = false;
				return orderitem;
			}

		} while (bOoLeAn);
		return null;
	}

	public OrderItem createNew() {

		LOGGER.info("Please enter an existing Order ID that you wish to add a Product to");
		Long orderId = utils.getLong();
		LOGGER.info("Please enter an Item ID that you  wish to add");
		Long itemId = utils.getLong();
		LOGGER.info("Please enter the quantity");
		Long quantity = utils.getLong();
		OrderItem orderitem = orderitemDAO.createNew(new OrderItem(itemId, quantity), orderId);
		LOGGER.info("Item added");
		return orderitem;
	}

	@Override
	public OrderItem update() {

		LOGGER.info("Please enter the ID of  the order you would  like to change");
		Long orderId = utils.getLong();
		LOGGER.info("Please enter item ID");
		Long itemId = utils.getLong();
		LOGGER.info("Please enter quantity");
		Long quantity = utils.getLong();
		OrderItem orderitem = orderitemDAO.update(new OrderItem(orderId, itemId, quantity));
		LOGGER.info("Order Updated");
		return orderitem;
	}

	@Override
	public int delete() {


		LOGGER.info("Please enter the id of an order you would like to change ");
		Long orderId = utils.getLong();
		LOGGER.info("Please enter the id of  of the item you would like to delete");
		Long itemId = utils.getLong();
		return orderitemDAO.deleteProduct(itemId , orderId);

	}

	@Override
	public OrderItem create() {

		return null;
	}
}