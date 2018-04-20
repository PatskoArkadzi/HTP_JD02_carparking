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
import static by.htp.carparking.web.util.WebConstantDeclaration.*;


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
				allOrders.add(buildOrder(rs));
			}
		} catch (SQLException e) {
			logger.error("Exception", e);
		}
		return allOrders;
	}

	public List<Order> readAll(String where) {
		List<Order> allOrders = null;
		try (Connection con = DataBaseConnection.getDBConnection(); Statement st = con.createStatement();) {
			ResultSet rs = st.executeQuery("SELECT * FROM `orders`" + where);
			allOrders = new ArrayList<>();
			while (rs.next()) {
				allOrders.add(buildOrder(rs));
			}
		} catch (SQLException e) {
			logger.error("Exception", e);
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
			//C:\apache\tomcat\apache-tomcat-9.0.4\apache-tomcat-9.0.4\logs\
		} catch (SQLException e) {
			logger.error("Exception", e);
		}
	}

	public boolean isCarFree(int carId, Date start, Date end) {
		try (Connection con = DataBaseConnection.getDBConnection(); Statement st = con.createStatement();) {
			ResultSet rs = st.executeQuery("SELECT * FROM `orders`");
			while (rs.next()) {
				if (start.before(rs.getDate("dateEnd")) || end.after(rs.getDate("dateStart")))
					return false;
			}
		} catch (SQLException e) {
			logger.error("Exception", e);
		}
		return true;
	}

	private Order buildOrder(ResultSet resultSet) throws SQLException {
		Order order =new Order();
		order.setId(resultSet.getInt(SQL_QUERY_COLUMN_NAME_ORDER_ID));
		order.setId(resultSet.getInt(SQL_QUERY_COLUMN_NAME_ORDER_USER_ID));
		order.setId(resultSet.getInt(SQL_QUERY_COLUMN_NAME_ORDER_CAR_ID));
		order.setDateStart(resultSet.getDate(SQL_QUERY_COLUMN_NAME_ORDER_DATE_START));
		order.setDateStart(resultSet.getDate(SQL_QUERY_COLUMN_NAME_ORDER_DATE_END));
		return order;
	}
}
