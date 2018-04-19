package by.htp.carparking.service.impl;

import java.util.List;

import by.htp.carparking.db.dao.CarDao;
import by.htp.carparking.domain.Car;
import by.htp.carparking.service.CarService;

public class CarServiceImpl implements CarService {
	CarDao carDao;

	public CarServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CarDao getCarDao() {
		return carDao;
	}

	public void setCarDao(CarDao carDao) {
		this.carDao = carDao;
	}

	@Override
	public List<Car> getCarList() {
		 return carDao.readAll();
	}

	@Override
	public void createCar(Car car) {
		carDao.create(car);
	}

	@Override
	public Car readCar(int id) {
		 return carDao.read(id);

	}

	@Override
	public void updateCar(Car car) {
		carDao.update(car);

	}

	@Override
	public void deleteCar(Car car) {
		carDao.delete(car);
	}

}
