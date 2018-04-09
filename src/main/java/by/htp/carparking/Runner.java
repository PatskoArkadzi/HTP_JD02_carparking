package by.htp.carparking;

import java.util.List;

import by.htp.carparking.db.dao.impl.CarDaoDataBaseImpl;
import by.htp.carparking.domain.Car;
import by.htp.carparking.service.Impl.CarServiceImpl;
import by.htp.carparking.service.Impl.OrderServiceImpl;


public class Runner {

	
	public static void main(String[] args) {
//		List<Car> cars=new CarDaoDataBaseImpl().readAll();
//		System.out.println(cars);
//new A().print();		
		new CarServiceImpl();
		new OrderServiceImpl();
		

	}

}
