package by.htp.carparking;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import by.htp.carparking.db.dao.CarDao;
import by.htp.carparking.db.dao.UserDao;
import by.htp.carparking.db.dao.aop.CarDaoAspectImpl;
import by.htp.carparking.db.dao.hbn.SessionFactoryManager;
import by.htp.carparking.db.dao.impl.CarDaoDataBaseImpl;
import by.htp.carparking.db.dao.impl.UserDaoDataBaseImpl;
import by.htp.carparking.domain.Car;
import by.htp.carparking.domain.User;

public class Runner {
	public static void main(String[] args) {
		// ApplicationContext applicationContext=new
		// ClassPathXmlApplicationContext("carparking-control.xml");
		/*
		 * CarDao dao=(CarDao)applicationContext.getBean("carDao"); UserDao
		 * userDao=(UserDao)applicationContext.getBean("userDao");
		 */
		CarDao dao = new CarDaoDataBaseImpl();
		UserDao userDao = new UserDaoDataBaseImpl();

		/*
		 * List<Car> cars=dao.readAll();
		 * 
		 * for(Car car: cars){ System.out.println(car); }
		 * System.out.println("--------------------"); System.out.println(dao.read(1));
		 * dao.create(new Car(1,"Audi","A6",false));
		 */

		/*
		 * SessionFactory factory=SessionFactoryManager.getSessionFactory(); Session
		 * session=factory.openSession(); System.out.println(session.hashCode());
		 */
		System.out.println(dao + " " + userDao);
		CarDaoAspectImpl c = new CarDaoAspectImpl();
		Car car = dao.read(15);
		User user = userDao.read(1);
		System.out.println(car + " " + user);

		c.purchase(car, user);

	}
}
