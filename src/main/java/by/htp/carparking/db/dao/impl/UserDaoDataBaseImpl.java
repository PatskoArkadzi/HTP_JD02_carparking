package by.htp.carparking.db.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import by.htp.carparking.db.DataBaseConnection;
import by.htp.carparking.db.dao.UserDao;
import by.htp.carparking.domain.User;

public class UserDaoDataBaseImpl implements UserDao {

	public UserDaoDataBaseImpl() {
	}

	@Override
	public void create(User entity) {
		try (Connection con = DataBaseConnection.getDBConnection()) {
			PreparedStatement ps = con.prepareStatement(
					"INSERT INTO `users`(`login`, `email`, `password`, `name`, `phoneNumber`, `roles_id`) VALUES (?,?,?,?,?,?)");
			ps.setString(1, entity.getLogin());
			ps.setString(2, entity.getEmail());
			ps.setString(3, entity.getPassword());
			ps.setString(4, entity.getName());
			ps.setString(5, entity.getPhoneNumber());
			ps.setInt(6, entity.getRoles_id());

			int count = ps.executeUpdate();
			if (count == 1) {
				ResultSet rs = ps.getGeneratedKeys();
				if (rs.next())
					entity.setId(rs.getInt(1));
			} else
				throw new SQLException();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public User read(int id) {		
		try (Connection con = DataBaseConnection.getDBConnection()) {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM `users` WHERE id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next())
				return new User(rs.getInt("id"), rs.getString("login"), rs.getString("email"), rs.getString("password"),
						rs.getString("name"), rs.getString("phoneNumber"), rs.getInt("roles_id"));
			else
				throw new IllegalArgumentException();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void update(User entity) {
		try (Connection con = DataBaseConnection.getDBConnection()) {
			PreparedStatement ps = con.prepareStatement("UPDATE `users` "
					+ "SET `login`=?,`email`=?,`password`=?,`name`=?,`phoneNumber`=?,`roles_id`=? WHERE id=?");
			ps.setString(1, entity.getLogin());
			ps.setString(2, entity.getEmail());
			ps.setString(2, entity.getPassword());
			ps.setString(2, entity.getName());
			ps.setString(2, entity.getPhoneNumber());
			ps.setInt(3, entity.getRoles_id());
			ps.setInt(3, entity.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(User entity) {
		try (Connection con = DataBaseConnection.getDBConnection()) {
			PreparedStatement ps = con.prepareStatement("DELETE FROM `users` WHERE id=?");
			ps.setInt(1, entity.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<User> readAll() {
		List<User> allUsers = null;
		try (Connection con = DataBaseConnection.getDBConnection(); Statement st = con.createStatement();) {
			ResultSet rs = st.executeQuery("SELECT * FROM `users`");
			allUsers = new ArrayList<>();
			while (rs.next()) {
				allUsers.add(
						new User(rs.getInt("id"), rs.getString("login"), rs.getString("email"), rs.getString("password"),
								rs.getString("name"), rs.getString("phoneNumber"), rs.getInt("roles_id")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return allUsers;
	}

}
