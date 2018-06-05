package by.htp.carparking.db.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import by.htp.carparking.db.DataBaseConnection;
import by.htp.carparking.db.dao.CarDao;
import by.htp.carparking.domain.Car;
import static by.htp.carparking.web.util.WebConstantDeclaration.*;

public class CarDaoDataBaseImpl implements CarDao {
//	private static final Logger logger = LogManager.getLogger();

	public CarDaoDataBaseImpl() {
	}

	@Override
	public void create(Car entity) {
		try (Connection con = DataBaseConnection.getDBConnection()) {
			PreparedStatement ps = con.prepareStatement(SQL_QUERY_CAR_CREATE);
			ps.setString(1, entity.getBrand());
			ps.setString(2, entity.getModel());

			int count = ps.executeUpdate();
			if (count == 1) {
				ResultSet rs = ps.getGeneratedKeys();
				if (rs.next())
					entity.setId(rs.getInt(1));
			}
		} catch (SQLException e) {
//			logger.error("Exception", e);
		}
	}

	@Override
	public Car read(int id) {
		try (Connection con = DataBaseConnection.getDBConnection()) {
			PreparedStatement ps = con.prepareStatement(SQL_QUERY_CAR_READ);
			ps.setInt(1, id);
			ResultSet resultSet = ps.executeQuery();
			if (resultSet.next())
				return buildCar(resultSet);
//			else
//				logger.error("Автомобиля с таким id нет");
		} catch (SQLException e) {
//			logger.error("Exception", e);
		}
		return null;
	}

	@Override
	public void update(Car entity) {
		try (Connection con = DataBaseConnection.getDBConnection()) {
			PreparedStatement ps = con.prepareStatement(SQL_QUERY_CAR_UPDATE);
			ps.setString(1, entity.getBrand());
			ps.setString(2, entity.getModel());
			ps.setInt(3, entity.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
//			logger.error("Exception", e);
		}
	}

	@Override
	public void delete(Car entity) {
		try (Connection con = DataBaseConnection.getDBConnection()) {
			PreparedStatement ps = con.prepareStatement(SQL_QUERY_CAR_DELETE);
			ps.setInt(1, entity.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
//			logger.error("Exception", e);
		}
	}

	@Override
	public List<Car> readAll() {
		List<Car> allCars = null;
		try (Connection con = DataBaseConnection.getDBConnection(); Statement st = con.createStatement();) {
			ResultSet resultSet = st.executeQuery(SQL_QUERY_CAR_READ_ALL);
			allCars = new ArrayList<>();
			while (resultSet.next()) {
				allCars.add(buildCar(resultSet));
			}
		} catch (SQLException e) {
//			logger.error("Exception", e);
		}
		return allCars;
	}

	private Car buildCar(ResultSet resultSet) throws SQLException {
		Car car = new Car();
		car.setId(resultSet.getInt(SQL_QUERY_COLUMN_NAME_CAR_ID));
		car.setBrand(resultSet.getString(SQL_QUERY_COLUMN_NAME_CAR_BRAND));
		car.setModel(resultSet.getString(SQL_QUERY_COLUMN_NAME_CAR_MODEL));
		return car;

	}

}