package by.htp.carparking;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.sql.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import by.htp.carparking.domain.springDataDomain.Car;
import by.htp.carparking.domain.springDataDomain.User;
import by.htp.carparking.repositories.CarRopository;
import by.htp.carparking.repositories.SpringDataConfig;

@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringDataConfig.class)
public class SpringDataTest {

	private static final Logger logger = LogManager.getLogger();
	@Autowired
	CarRopository carRepository;

	@Test
	public void findAllTest() {
		List<Car> cars = carRepository.findAll();
		assertTrue(cars.size() == 3);
		assertFalse(cars.isEmpty());
	}

	@Test
	public void findbyIdTest() {
		Car car = carRepository.findById(1);
		assertTrue("Mercedes".equals(car.getBrand()) && "e8".equals(car.getModel()));
	}

	@Test
	public void findAllCarsByUserFromDateTest() {
		User user = new User();
		user.setId(2);
		List<Car> cars = carRepository.findAllCarsByUserFromDate(user, Date.valueOf("2018-06-30"));
		assertTrue(cars.size() == 1);
		assertFalse(cars.isEmpty());
	}
	@Test
	public void findMostPopularCarInDatesTest() {
		Car car = carRepository.findMostPopularCarInDates(Date.valueOf("2018-06-30"), Date.valueOf("2018-07-13"));
		logger.info("1 "+car);
		assertTrue("Mercedes".equals(car.getBrand()) && "e8".equals(car.getModel()));
	}
	@Test
	public void findMostPopularCarInDatesTest2() {
		Car car = carRepository.findMostPopularCarInDates(Date.valueOf("2018-07-06"), Date.valueOf("2018-07-13"));
		logger.info("2 "+car);
		assertTrue("Audi".equals(car.getBrand()) && "s5".equals(car.getModel()));
	}
}
