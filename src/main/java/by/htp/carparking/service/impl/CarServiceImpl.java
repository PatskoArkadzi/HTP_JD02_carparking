package by.htp.carparking.service.impl;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import by.htp.carparking.db.dao.BaseDao;
import by.htp.carparking.db.dao.CarDao;
import by.htp.carparking.db.dao.DaoFactory;
import by.htp.carparking.db.dao.impl.CarDaoDataBaseImpl;
import by.htp.carparking.domain.Car;
import by.htp.carparking.service.CarService;
import by.htp.carparking.service.OrderService;

public class CarServiceImpl implements CarService {

	@Override
	public List<Car> getCarList() {
		return CAR_DAO.readAll();
	}

	@Override
	public void createCar(Car car) {
		CAR_DAO.create(car);
	}

	@Override
	public Car readCar(int id) {
		return CAR_DAO.read(id);
		
	}

	@Override
	public void updateCar(Car car) {
		CAR_DAO.update(car);
		
	}

	@Override
	public void deleteCar(Car car) {
		CAR_DAO.delete(car);
	}

}
