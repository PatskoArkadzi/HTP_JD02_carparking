package by.htp.carparking.db.dao.aop;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import by.htp.carparking.db.DataBaseConnection;
import by.htp.carparking.db.dao.CarDao;
import by.htp.carparking.domain.Car;
import by.htp.carparking.domain.User;

import static by.htp.carparking.web.util.WebConstantDeclaration.*;

@Component
public class CarDaoAspectImpl implements CarDao {
	// private static final Logger logger = LogManager.getLogger();

	public CarDaoAspectImpl() {
	}

	public static Connection con;

	public void purchase(Car car, User user) {
		if (con != null) {
			try {
				PreparedStatement ps = con.prepareStatement("SELECT leased FROM cars WHERE id=?");
				ps.setInt(1, car.getId());
				ResultSet resultSet = ps.executeQuery();
				if (resultSet.next()) {
					boolean isCarLeased = resultSet.getBoolean("leased");
					if (!isCarLeased) {
						ps = con.prepareStatement("UPDATE cars SET leased = ? WHERE id = ?");
						ps.setBoolean(1, true);
						ps.setInt(2, car.getId());
						ps.executeUpdate();

						ps = con.prepareStatement("UPDATE users SET balance = balance - ? WHERE id = ?");
						ps.setBigDecimal(1, car.getPricePerDay());
						ps.setInt(2, user.getId());
						ps.executeUpdate();
					} else {
						System.out.println("rollback");
						con.rollback();
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void create(Car entity) {
		try (Connection con = DataBaseConnection.connect()) {
			PreparedStatement ps = con.prepareStatement(SQL_QUERY_CAR_CREATE);
			ps.setString(1, entity.getBrand());
			ps.setString(2, entity.getModel());
			ps.setBoolean(3, entity.isLeased());
			ps.setBigDecimal(4, entity.getPricePerDay());

			int count = ps.executeUpdate();
			if (count == 1) {
				ResultSet rs = ps.getGeneratedKeys();
				if (rs.next())
					entity.setId(rs.getInt(1));
			}
		} catch (SQLException e) {
			// logger.error("Exception", e);
		}
	}

	@Override
	public Car read(int id) {
		try (Connection con = DataBaseConnection.connect()) {
			PreparedStatement ps = con.prepareStatement(SQL_QUERY_CAR_READ);
			ps.setInt(1, id);
			ResultSet resultSet = ps.executeQuery();
			if (resultSet.next())
				return buildCar(resultSet);
			// else
			// logger.error("Автомобиля с таким id нет");
		} catch (SQLException e) {
			e.printStackTrace();
			// logger.error("Exception", e);
		}
		return null;
	}

	@Override
	public void update(Car entity) {
		try (Connection con = DataBaseConnection.connect()) {
			PreparedStatement ps = con.prepareStatement(SQL_QUERY_CAR_UPDATE);
			ps.setString(1, entity.getBrand());
			ps.setString(2, entity.getModel());
			ps.setBoolean(3, entity.isLeased());
			ps.setBigDecimal(4, entity.getPricePerDay());
			ps.setInt(5, entity.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			// logger.error("Exception", e);
		}
	}

	@Override
	public void delete(Car entity) {
		try (Connection con = DataBaseConnection.connect()) {
			PreparedStatement ps = con.prepareStatement(SQL_QUERY_CAR_DELETE);
			ps.setInt(1, entity.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			// logger.error("Exception", e);
		}
	}

	@Override
	public List<Car> readAll() {
		List<Car> allCars = null;
		try (Connection con = DataBaseConnection.connect(); Statement st = con.createStatement();) {
			ResultSet resultSet = st.executeQuery(SQL_QUERY_CAR_READ_ALL);
			allCars = new ArrayList<>();
			while (resultSet.next()) {
				allCars.add(buildCar(resultSet));
			}
		} catch (SQLException e) {
			// logger.error("Exception", e);
		}
		return allCars;
	}

	private Car buildCar(ResultSet resultSet) throws SQLException {
		Car car = new Car();
		car.setId(resultSet.getInt(SQL_QUERY_COLUMN_NAME_CAR_ID));
		car.setBrand(resultSet.getString(SQL_QUERY_COLUMN_NAME_CAR_BRAND));
		car.setModel(resultSet.getString(SQL_QUERY_COLUMN_NAME_CAR_MODEL));
		car.setLeased(resultSet.getBoolean(SQL_QUERY_COLUMN_NAME_CAR_LEASED));
		car.setPricePerDay(resultSet.getBigDecimal(SQL_QUERY_COLUMN_NAME_CAR_PRICE_PER_DAY));
		return car;

	}

}