package by.htp.carparking.db.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import by.htp.carparking.db.DataBaseConnection;
import by.htp.carparking.db.dao.BaseDao;
import by.htp.carparking.domain.Car;

public class CarDBDaoImp implements BaseDao<Car> {

	@Override
	public void create(Car entity) {
		try (Connection con = DataBaseConnection.getDBConnection(); Statement st = con.createStatement();) {
			int id=st.executeUpdate(String.format("INSERT INTO `cars`(`brand`, `model`) VALUES ('%s','%s')",
					entity.getBrand(), entity.getModel()));
			if (id > 0) entity.setId(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Car read(int id) {
		try (Connection con = DataBaseConnection.getDBConnection(); Statement st = con.createStatement();) {
			ResultSet rs = st.executeQuery(String.format("SELECT * FROM `cars` WHERE id=%d",id));
			System.out.println(rs);
			rs.next();
			return new Car(rs.getInt("id"), rs.getString("brand"), rs.getString("model"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void update(Car entity) {
		try (Connection con = DataBaseConnection.getDBConnection(); Statement st = con.createStatement();) {
			st.executeUpdate(String.format("UPDATE `cars` " + "SET `brand`='%s',`model`='%s' WHERE id=%d",
					entity.getBrand(), entity.getModel(), entity.getId()));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Car entity) {
		try (Connection con = DataBaseConnection.getDBConnection(); Statement st = con.createStatement();) {
			st.executeUpdate(
	                String.format("DELETE FROM `cars` WHERE id=%d", entity.getId()));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Car> readAll() {
		List<Car> allCars = null;
		try (Connection con = DataBaseConnection.getDBConnection(); Statement st = con.createStatement();) {
			ResultSet rs = st.executeQuery("SELECT * FROM `cars`");
			allCars = new ArrayList<>();
			while (rs.next()) {
				allCars.add(new Car(rs.getInt("id"), rs.getString("brand"), rs.getString("model")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return allCars;
	}

}