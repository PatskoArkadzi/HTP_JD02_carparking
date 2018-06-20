package by.htp.carparking.service.impl;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import by.htp.carparking.db.dao.OrderDao;
import by.htp.carparking.domain.Order;
import by.htp.carparking.service.OrderService;

@Component
public class OrderServiceImpl implements OrderService {
	@Autowired
	OrderDao orderDao;

	public OrderServiceImpl() {
	}

	public OrderDao getOrderDao() {
		return orderDao;
	}

	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

	@Override
	public void orderCar(int userId, int carId, Date dateStart, Date dateEnd) {
		orderDao.insertNewOrder(userId, carId, dateStart, dateEnd);
	}

	public boolean isCarFree(int carId, Date start, Date end) {
		List<Order> list = orderDao.readAll(String.format("where car_id=" + carId));
		for (Order order : list) {
			if ((start.after(order.getDateStart()) && start.before(order.getDateEnd()))
					|| (end.before(order.getDateStart()) && end.after(order.getDateStart())))
				return false;
		}
		return true;
	}
}
