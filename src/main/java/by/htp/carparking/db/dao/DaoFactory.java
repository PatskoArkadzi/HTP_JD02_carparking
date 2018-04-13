package by.htp.carparking.db.dao;

import by.htp.carparking.db.dao.impl.CarDaoDataBaseImpl;
import by.htp.carparking.db.dao.impl.OrderDaoDataBaseImpl;

public class DaoFactory {
	private static DaoFactory createInstance() {
		return new DaoFactory();
	}
	private CarDaoDataBaseImpl getCarDao() {
		return new CarDaoDataBaseImpl();
	}
	private OrderDaoDataBaseImpl getOrderDao() {
		return new OrderDaoDataBaseImpl();
	}

	/*public BaseDao getDao() {
		String callerClassName = new Throwable().getStackTrace()[1].getFileName().replace(".java", "");
		if (callerClassName.equals("CarServiceImpl"))
			return new CarDaoDataBaseImpl();
		else if (callerClassName.equals("OrderServiceImpl"))
			return new OrderDaoDataBaseImpl();
		else
			return null;
	}*/
	
}
