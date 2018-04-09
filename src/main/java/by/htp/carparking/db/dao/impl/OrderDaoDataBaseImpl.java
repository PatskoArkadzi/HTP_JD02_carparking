package by.htp.carparking.db.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.LogManager;

import org.apache.logging.log4j.Logger;

import by.htp.carparking.db.DataBaseConnection;
import by.htp.carparking.db.dao.OrderDao;
import by.htp.carparking.domain.Order;

public class OrderDaoDataBaseImpl implements OrderDao {

	// private static final Logger logger = (Logger) LogManager.getLogManager();

	@Override
	public void create(Order entity) {
		// TODO Auto-generated method stub
	}

	@Override
	public Order read(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Order entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Order entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Order> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertNewOrder(int userId, int carId) {
		Connection conn = DataBaseConnection.getDBConnection();
		try (PreparedStatement ps = conn.prepareStatement("INSERT INTO orders (userId, carId) VALUES (?,?)")) {

			ps.setInt(1, userId);
			ps.setInt(2, carId);

			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
