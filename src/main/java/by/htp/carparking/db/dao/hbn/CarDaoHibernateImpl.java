package by.htp.carparking.db.dao.hbn;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import by.htp.carparking.db.dao.CarDao;
import by.htp.carparking.domain.Car;

@Component
public class CarDaoHibernateImpl implements CarDao{

	@Override
	public void create(Car entity) {
		SessionFactory factory=SessionFactoryManager.getSessionFactory();
		Session session=factory.openSession();
		Transaction tx = session.beginTransaction();

		session.save(entity);
		tx.commit();
		session.close();
	}

	@Override
	public Car read(int id) {
		SessionFactory factory=SessionFactoryManager.getSessionFactory();
		Session session=factory.openSession();
		
		Criteria criteria=session.createCriteria(Car.class);
		criteria.add(Restrictions.eq("id", id));
		Car car=(Car) criteria.list().get(0);
		session.close();
		return car;
	}

	@Override
	public void update(Car entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Car entity) {
		SessionFactory factory = SessionFactoryManager.getSessionFactory();
		Session session = factory.openSession();
		session.getTransaction().begin();
		session.delete(entity);
		session.getTransaction().commit();
		session.close();		
	}

	@Override
	public List<Car> readAll() {
		SessionFactory factory=SessionFactoryManager.getSessionFactory();
		Session session=factory.openSession();
		
		Criteria criteria=session.createCriteria(Car.class);
		List<Car> cars=criteria.list();
		session.close();
		return cars;
	}

}
