package by.htp.carparking.db.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.htp.carparking.db.DataBaseConnection;
import by.htp.carparking.db.dao.OrderDao;
import by.htp.carparking.domain.Order;

public class OrderDaoDataBaseImpl implements OrderDao {

	public OrderDaoDataBaseImpl() {
	}

	private static final Logger logger = LogManager.getLogger();

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
		List<Order> allOrders = null;
		try (Connection con = DataBaseConnection.getDBConnection(); Statement st = con.createStatement();) {
			ResultSet rs = st.executeQuery("SELECT * FROM `orders`");
			allOrders = new ArrayList<>();
			while (rs.next()) {
				allOrders.add(new Order(rs.getInt("id"), rs.getInt("user_id"), rs.getInt("car_id"),
						rs.getDate("dateStart"), rs.getDate("dateEnd")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return allOrders;
	}

	public List<Order> readAll(String where) {
		List<Order> allOrders = null;
		try (Connection con = DataBaseConnection.getDBConnection(); Statement st = con.createStatement();) {
			ResultSet rs = st.executeQuery("SELECT * FROM `orders`" + where);
			allOrders = new ArrayList<>();
			while (rs.next()) {
				allOrders.add(new Order(rs.getInt("id"), rs.getInt("user_id"), rs.getInt("car_id"),
						rs.getDate("dateStart"), rs.getDate("dateEnd")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return allOrders;
	}

	@Override
	public void insertNewOrder(int userId, int carId, Date dateStart, Date dateEnd) {
		Connection conn = DataBaseConnection.getDBConnection();
		try (PreparedStatement ps = conn
				.prepareStatement("INSERT INTO orders (user_id, car_id, dateStart, dateEnd) VALUES (?,?,?,?)")) {

			ps.setInt(1, userId);
			ps.setInt(2, carId);
			ps.setDate(3, dateStart);
			ps.setDate(4, dateEnd);
			ps.executeUpdate();

			logger.info("The car was ordered succesfully");
			// C:\apache\tomcat\apache-tomcat-9.0.4\apache-tomcat-9.0.4\logs\
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// select * from orders where car_id=1
	public boolean isCarFree(int carId, Date start, Date end) {
		StringBuilder sb = new StringBuilder();
		try (Connection con = DataBaseConnection.getDBConnection(); Statement st = con.createStatement();) {
			ResultSet rs = st.executeQuery("SELECT * FROM `orders`");
			while (rs.next()) {
				if (start.before(rs.getDate("dateEnd")) || end.after(rs.getDate("dateStart"))) {
					System.out.println("start" + start);
					System.out.println("dateEnd" + rs.getDate("dateEnd"));
					System.out.println("end" + end);
					System.out.println("dateStart" + rs.getDate("dateStart"));
					return false;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return true;
	}

}
