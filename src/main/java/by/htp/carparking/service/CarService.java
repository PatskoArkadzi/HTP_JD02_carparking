package by.htp.carparking.service;

import java.util.List;

import by.htp.carparking.domain.Car;

public interface CarService extends Service {
	List<Car> getCarList();
	void createCar(Car car);
	Car readCar(int id);
	void updateCar(Car car);
	void deleteCar(Car car);
}
