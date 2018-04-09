package by.htp.carparking.service.Impl;

import java.util.List;

import by.htp.carparking.db.dao.BaseDao;
import by.htp.carparking.db.dao.CarDao;
import by.htp.carparking.db.dao.DaoFactory;
import by.htp.carparking.db.dao.impl.CarDaoDataBaseImpl;
import by.htp.carparking.domain.Car;
import by.htp.carparking.service.CarService;

public class CarServiceImpl implements CarService {
	// TODO change to IoC, singleton
	private CarDao dao = (CarDao) DaoFactory.getDao();
//	private CarDao carDao = new CarDaoDataBaseImpl();

	@Override
	public List<Car> getCarList() {
		return dao.readAll();
	}

	@Override
	public void createCar(Car car) {
		dao.create(car);
	}

	@Override
	public Car readCar(int id) {
		return dao.read(id);
		
	}

	@Override
	public void updateCar(Car car) {
		dao.update(car);
		
	}

	@Override
	public void deleteCar(Car car) {
		dao.delete(car);
	}

}
