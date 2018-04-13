package by.htp.carparking.service;

import by.htp.carparking.service.impl.CarServiceImpl;
import by.htp.carparking.service.impl.OrderServiceImpl;

public class ServiceFactory {
	
	private static ServiceFactory createInstance(){
		return new ServiceFactory();
	}
	private CarServiceImpl createCarServiceImpl() {
		return new CarServiceImpl();
	}
	private OrderServiceImpl createOrderServiceImpl() {
		return new OrderServiceImpl();
	}

}
