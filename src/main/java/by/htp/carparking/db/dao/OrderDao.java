package by.htp.carparking.db.dao;

import by.htp.carparking.domain.Order;

public interface OrderDao extends BaseDao<Order> {
	
	void insertNewOrder(int userId, int carId);
}
