package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import com.qa.ims.persistence.dao.ItemDAO;

import com.qa.ims.persistence.domain.Item;

import com.qa.ims.utils.Utils;


public class ItemController implements CrudController<Item> {
	public static final Logger LOGGER = LogManager.getLogger();

	private ItemDAO itemDAO;
	private Utils utils;

	public ItemController(ItemDAO itemDAO, Utils utils) {
		super();
		this.itemDAO = itemDAO;
		this.utils = utils;
	}

	@Override
	public List<Item> readAll() {
		// TODO Auto-generated method stub
		List<Item> items = itemDAO.readAll();
		for (Item item : items) {
			LOGGER.info(item);
		}
		return items;
	}

	@Override
	public Item create() {
		// TODO Auto-generated method stub
		LOGGER.info("Please enter a Product Name");
		String item_name = utils.getString();
		LOGGER.info("Please enter a Product Price");
		Double item_value = utils.getDouble();
		Item item = itemDAO.create(new Item(item_name, item_value));
		LOGGER.info("Product created");
		return item;
	}

	@Override
	public Item update() {
		// TODO Auto-generated method stub
		LOGGER.info("Please enter the id of the Product you would like to update");
		Long item_id = utils.getLong();
		LOGGER.info("Please enter a Product Name");
		String firstName = utils.getString();
		LOGGER.info("Please enter a Product Price");
		Double surname = utils.getDouble();
		Item item = itemDAO.update(new Item(item_id, firstName, surname));
		LOGGER.info("Product Updated");
		return item;
	}

	@Override
	public int delete() {
		// TODO Auto-generated method stub
		LOGGER.info("Please enter the id of the Product you would like to delete");
		Long item_id = utils.getLong();
		return itemDAO.delete(item_id);
	}

}
