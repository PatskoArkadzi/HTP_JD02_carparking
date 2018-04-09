package by.htp.carparking.service;

import by.htp.carparking.service.Impl.CarServiceImpl;
import by.htp.carparking.service.Impl.OrderServiceImpl;

public class ServiceFactory {
	public static CarService getCarService() {
		return new CarServiceImpl();
	}
	public static OrderService getOrderService() {
		return new OrderServiceImpl();
	}

}
