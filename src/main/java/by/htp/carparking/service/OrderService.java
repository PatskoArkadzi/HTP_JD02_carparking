package by.htp.carparking.service;

import java.sql.Date;

public interface OrderService extends Service {
	void orderCar(int userId, int carId, Date start,Date end);
	boolean isCarFree(int carId, Date start, Date end);
}
