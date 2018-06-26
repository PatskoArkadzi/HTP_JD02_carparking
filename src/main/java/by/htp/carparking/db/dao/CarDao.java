package by.htp.carparking.db.dao;

import java.sql.Connection;

import by.htp.carparking.domain.Car;
import by.htp.carparking.domain.User;

public interface CarDao extends BaseDao<Car> {
	public void purchase(Car car, User user, Connection con);
	//TODO add specific methods
}
