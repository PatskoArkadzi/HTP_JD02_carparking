package by.htp.carparking;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import by.htp.carparking.db.dao.CarDao;
import by.htp.carparking.db.dao.hbn.SessionFactoryManager;
import by.htp.carparking.domain.Car;

public class Runner {
	public static void main(String[] args) {
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("carparking-control.xml");
		CarDao dao=(CarDao)applicationContext.getBean("carDao");
		
		List<Car> cars=dao.readAll();
		
		for(Car car: cars){
			System.out.println(car);
		}
		System.out.println("--------------------");
		System.out.println(dao.read(1));
		dao.create(new Car(1,"Audi","A6"));
		
		/*SessionFactory factory=SessionFactoryManager.getSessionFactory();
		Session session=factory.openSession();
		System.out.println(session.hashCode());*/

	}
}
