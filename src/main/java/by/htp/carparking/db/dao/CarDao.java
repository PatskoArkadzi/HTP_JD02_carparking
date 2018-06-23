package by.htp.carparking.db.dao;

import by.htp.carparking.domain.Car;
import by.htp.carparking.domain.User;

public interface CarDao extends BaseDao<Car> {
	public void purchase(Car car, User user);
	//TODO add specific methods
}
