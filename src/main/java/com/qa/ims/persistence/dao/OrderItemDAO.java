package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.domain.OrderItem;
import com.qa.ims.utils.DBUtils;

public class OrderItemDAO implements Dao<OrderItem> {

	public static final Logger LOGGER = LogManager.getLogger();

	@Override
	public OrderItem modelFromResultSet(ResultSet resultSet) throws SQLException {
		Long order_id = resultSet.getLong("order_id");
		Long item_id = resultSet.getLong("item_id");
		Long quantity = resultSet.getLong("quantity");

		return new OrderItem(order_id, item_id, quantity);
	}

	public OrderItem modelFromResultSet2(ResultSet resultSet) throws SQLException {
		Long order_id = resultSet.getLong("order_id");
		Long item_id = resultSet.getLong("item_id");
		Long quantity = resultSet.getLong("quantity");
		String first_name = resultSet.getString("first_name");
		String surname = resultSet.getString("surname");
		String item_name = resultSet.getString("item_name");
		Double item_value = resultSet.getDouble("item_value");

		return new OrderItem(order_id, item_id, quantity, first_name, surname, item_name, item_value);
	}

	public OrderItem modelFromResultSet3(ResultSet resultSet) throws SQLException {
		Double cost = resultSet.getDouble("Total Cost");
		return new OrderItem(cost);
	}

	public OrderItem readLatest() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement
						.executeQuery("SELECT * FROM ordersitems ORDER BY order_id DESC LIMIT 1");) {
			resultSet.next();
			return modelFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public List<OrderItem> readAll() {
		// TODO Auto-generated method stub
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(
						"SELECT *  FROM ordersitems n LEFT JOIN orders o ON n.order_id = o.order_id LEFT JOIN items i ON n.item_id = i.item_id LEFT JOIN customers c ON c.id = o.customer_id ORDER BY o.order_id;");) {
			List<OrderItem> orderitems = new ArrayList<>();
			while (resultSet.next()) {
				orderitems.add(modelFromResultSet2(resultSet));
			}
			return orderitems;
		} catch (SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
	}

	@Override
	public OrderItem read(Long order_id) {
		// TODO Auto-generated method stub
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("SELECT * FROM ordersitems WHERE order_id = ?");) {
			statement.setLong(1, order_id);
			try (ResultSet resultSet = statement.executeQuery();) {
				resultSet.next();
				return modelFromResultSet(resultSet);
			}
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public OrderItem create(OrderItem orderitem) {
		// TODO Auto-generated method stub

		return null;
	}

	public OrderItem createNew(OrderItem orderitem, Long order_id) {
		// TODO Auto-generated method stub
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("INSERT INTO ordersitems(order_id ,item_id, quantity) VALUES (? ,?, ?)");) {
			statement.setLong(2, orderitem.getItem_id());
			statement.setLong(3, orderitem.getQuantity());
			statement.setLong(1, order_id);
			statement.executeUpdate();

			return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public OrderItem update(OrderItem orderitem) {
		// TODO Auto-generated method stub
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("UPDATE ordersitems SET quantity = ? WHERE item_id = ? and order_id = ?;");) {
			statement.setLong(2, orderitem.getItem_id());
			statement.setLong(1, orderitem.getQuantity());
			statement.setLong(3, orderitem.getOrder_id());
			statement.executeUpdate();
			return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public int delete(long item_id) {
		// TODO Auto-generated method stub
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("DELETE FROM ordersitems WHERE item_id = ?");) {
			statement.setLong(1, item_id);
			return statement.executeUpdate();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return 0;
	}

	public OrderItem calculateOrderCost(Long order_id) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("SELECT SUM(i.item_value*n.quantity) as `Total Cost`\r\n"
								+ "FROM ordersitems n\r\n" + "LEFT JOIN orders o ON n.order_id = o.order_id\r\n"
								+ "LEFT JOIN items i ON n.item_id = i.item_id\r\n"
								+ "Left Join customers c on c.id = o.customer_id \r\n" + "where o.order_id = ? ;");) {
			statement.setLong(1, order_id);
			try (ResultSet resultSet = statement.executeQuery();) {
				resultSet.next();
				return modelFromResultSet3(resultSet);
			}
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;

	}
}
