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

public class CarDaoDataBaseImpl implements CarDao {

	public CarDaoDataBaseImpl() {
	}

	@Override
	public void create(Car entity) {
		try (Connection con = DataBaseConnection.getDBConnection()) {
			PreparedStatement ps = con.prepareStatement("INSERT INTO `cars`(`brand`, `model`) VALUES (?,?)");
			ps.setString(1, entity.getBrand());
			ps.setString(2, entity.getModel());

			int count = ps.executeUpdate();
			if (count == 1) {
				ResultSet rs = ps.getGeneratedKeys();
				if (rs.next())
					entity.setId(rs.getInt(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Car read(int id) {
		try (Connection con = DataBaseConnection.getDBConnection()) {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM `cars` WHERE id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next())
				return new Car(rs.getInt("id"), rs.getString("brand"), rs.getString("model"));
			else throw new IllegalArgumentException();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void update(Car entity) {
		try (Connection con = DataBaseConnection.getDBConnection()) {
			PreparedStatement ps = con.prepareStatement("UPDATE `cars` " + "SET `brand`=?,`model`=? WHERE id=?");
			ps.setString(1, entity.getBrand());
			ps.setString(2, entity.getModel());
			ps.setInt(3, entity.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Car entity) {
		try (Connection con = DataBaseConnection.getDBConnection()) {
			PreparedStatement ps = con.prepareStatement("DELETE FROM `cars` WHERE id=?");
			ps.setInt(1, entity.getId());
			ps.executeUpdate();
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