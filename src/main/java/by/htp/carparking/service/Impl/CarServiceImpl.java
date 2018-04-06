package by.htp.carparking.service.Impl;

import java.util.List;

import by.htp.carparking.db.dao.CarDao;
import by.htp.carparking.db.dao.impl.CarDaoDataBaseImpl;
import by.htp.carparking.domain.Car;
import by.htp.carparking.service.CarService;

public class CarServiceImpl implements CarService {
	// TODO change to IoC, singletone
	private CarDao carDao = new CarDaoDataBaseImpl();

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
