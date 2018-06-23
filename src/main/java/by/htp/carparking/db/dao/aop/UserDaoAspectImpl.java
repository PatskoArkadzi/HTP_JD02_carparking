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
import by.htp.carparking.db.dao.UserDao;
import by.htp.carparking.domain.User;

@Component
public class UserDaoAspectImpl implements UserDao {

	private static final Logger logger = LogManager.getLogger();

	public UserDaoAspectImpl() {
	}

	@Override
	public void create(User entity) {
		try (Connection con = DataBaseConnection.connect()) {
			PreparedStatement ps = con.prepareStatement(
					"INSERT INTO `users`(`login`, `email`, `password`, `name`, `phoneNumber`, `balance`, `roles_id`) VALUES (?,?,?,?,?,?)");
			ps.setString(1, entity.getLogin());
			ps.setString(2, entity.getEmail());
			ps.setString(3, entity.getPassword());
			ps.setString(4, entity.getName());
			ps.setString(5, entity.getPhoneNumber());
			ps.setBigDecimal(6, entity.getBalance());
			ps.setInt(7, entity.getRoles_id());

			int count = ps.executeUpdate();
			if (count == 1) {
				ResultSet rs = ps.getGeneratedKeys();
				if (rs.next())
					entity.setId(rs.getInt(1));
			} else
				throw new SQLException();
		} catch (SQLException e) {
			logger.error("Exception", e);
		}
	}

	@Override
	public User read(int id) {
		try (Connection con = DataBaseConnection.connect()) {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM `users` WHERE id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next())
				return new User(rs.getInt("id"), rs.getString("login"), rs.getString("email"), rs.getString("password"),
						rs.getString("name"), rs.getString("phoneNumber"), rs.getBigDecimal("balance"),
						rs.getInt("roles_id"));
			else
				throw new IllegalArgumentException();
		} catch (SQLException e) {
			logger.error("Exception", e);
		}
		return null;
	}

	@Override
	public void update(User entity) {
		try (Connection con = DataBaseConnection.connect()) {
			PreparedStatement ps = con.prepareStatement("UPDATE `users` "
					+ "SET `login`=?,`email`=?,`password`=?,`name`=?,`phoneNumber`=?,`balance`=?,`roles_id`=? WHERE id=?");
			ps.setString(1, entity.getLogin());
			ps.setString(2, entity.getEmail());
			ps.setString(3, entity.getPassword());
			ps.setString(4, entity.getName());
			ps.setString(5, entity.getPhoneNumber());
			ps.setBigDecimal(6, entity.getBalance());
			ps.setInt(7, entity.getRoles_id());
			ps.setInt(8, entity.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			logger.error("Exception", e);
		}
	}

	@Override
	public void delete(User entity) {
		try (Connection con = DataBaseConnection.connect()) {
			PreparedStatement ps = con.prepareStatement("DELETE FROM `users` WHERE id=?");
			ps.setInt(1, entity.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			logger.error("Exception", e);
		}
	}

	@Override
	public List<User> readAll() {
		List<User> allUsers = null;
		try (Connection con = DataBaseConnection.connect(); Statement st = con.createStatement();) {
			ResultSet rs = st.executeQuery("SELECT * FROM `users`");
			allUsers = new ArrayList<>();
			while (rs.next()) {
				allUsers.add(new User(rs.getInt("id"), rs.getString("login"), rs.getString("email"),
						rs.getString("password"), rs.getString("name"), rs.getString("phoneNumber"),
						rs.getBigDecimal("balance"), rs.getInt("roles_id")));
			}
		} catch (SQLException e) {
			logger.error("Exception", e);
		}
		return allUsers;
	}

}
