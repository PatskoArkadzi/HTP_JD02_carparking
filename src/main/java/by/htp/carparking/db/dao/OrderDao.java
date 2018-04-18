package by.htp.carparking.db.dao;

import java.sql.Date;
import java.util.List;

import by.htp.carparking.domain.Order;

public interface OrderDao extends BaseDao<Order> {

	void insertNewOrder(int userId, int carId, Date dateStart, Date dateEnd);
	List <Order>readAll(String where);
}
