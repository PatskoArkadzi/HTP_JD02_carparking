package by.htp.carparking.repositories;

import java.util.List;

import java.sql.Date;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import by.htp.carparking.domain.springDataDomain.Car;
import by.htp.carparking.domain.springDataDomain.User;

public interface CarRopository extends CrudRepository<Car, Integer> {

	List<Car> findAll();

	@Query(value = "select c from Car c inner join c.orders o where o.user=:user and o.dateStart > :date")
	List<Car> findAllCarsByUserFromDate(@Param("user") User user, @Param("date") Date date);

	Car findById(int id);

	@Query(nativeQuery = true, value = "select * from cars c inner join orders o on c.id=o.car_id\r\n"
			+ "where (o.dateStart between :dateStart and :dateEnd) and (o.dateEnd between :dateStart and :dateEnd)\r\n"
			+ "group by o.car_id order by count(o.id) desc limit 1")
	Car findMostPopularCarInDates(@Param("dateStart") Date dateStart, @Param("dateEnd") Date dateEnd);
}
