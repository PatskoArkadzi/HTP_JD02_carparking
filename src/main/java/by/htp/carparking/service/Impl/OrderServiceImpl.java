package by.htp.carparking.service.Impl;

import by.htp.carparking.db.dao.DaoFactory;
import by.htp.carparking.db.dao.OrderDao;
import by.htp.carparking.db.dao.impl.OrderDaoDataBaseImpl;
import by.htp.carparking.service.OrderService;

public class OrderServiceImpl implements OrderService {
	//TODO add Ioc
	private OrderDao orderDao = (OrderDao) DaoFactory.getDao();
//	private OrderDao orderDao = new OrderDaoDataBaseImpl();

	@Override
	public void orderCar(int userId, int carId) {
		orderDao.insertNewOrder(userId, carId);
	}

}
