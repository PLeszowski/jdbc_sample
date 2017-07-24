package pl.rozkocha.szymon.jdbc_sample;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseUsersDAO implements IDAO<User> {
	private static DatabaseUsersDAO instance = null;
	
	public static void init(DatabaseServer server) {
		if(instance == null) {
			instance = new DatabaseUsersDAO(server);
		}
	}
	
	public static DatabaseUsersDAO getInstance() {
		return instance;
	}
	
	public static final String ID_COLUMN = "id";
	public static final String NAME_COLUMN = "name";
	public static final String SURNAME_COLUMN = "surname";
	public static final String ROLE_ID_COLUMN = "role_id";
	public static final String ROLE_NAME_COLUMN = "roles.name";
	
	public static final String GET_ALL_SQL = "select users.id, users.name, surname, role_id, roles.name from users inner join roles where users.role_id = roles.id;";
	
	private DatabaseServer server;
	
	private DatabaseUsersDAO(DatabaseServer server) {
		this.server = server;
		
		try {
			server.connect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void close() {
		server.close();
	}
	
	public List<User> get() {
		List<User> users = new ArrayList<>();
		
		Statement statement = null;
        try {
			statement = server.createStatement();
			
			ResultSet resultSet = statement.executeQuery(GET_ALL_SQL);
			while(resultSet.next()) {
				int id = resultSet.getInt(resultSet.findColumn(ID_COLUMN));
				String name = resultSet.getString(resultSet.findColumn(NAME_COLUMN));
				String surname = resultSet.getString(resultSet.findColumn(SURNAME_COLUMN));
				int roleId = resultSet.getInt(resultSet.findColumn(ROLE_ID_COLUMN));
				String roleName = resultSet.getString(resultSet.findColumn(ROLE_NAME_COLUMN));
				
				users.add(new User(id, name, surname, new Role(roleId, roleName)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return users;
	}

	public void add(User user) {
		Statement statement = null;
        try {
			statement = server.createStatement();
			
			statement.executeUpdate("insert into users (name, surname, role_id) values (\"" +
					user.getName() + "\", \"" + user.getSurname() + "\", \"" + user.getRole().getId() + "\"");
        } catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void update(User user) {
		Statement statement = null;
        try {
			statement = server.createStatement();
			
			statement.executeUpdate("update users set name = \"" + user.getName() + 
					"\", surname = \"" + user.getSurname() + 
					"\", role_id = \"" + user.getRole().getId() + 
					"\" where id = " + user.getId());
        } catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void delete(User user) {
		Statement statement = null;
        try {
			statement = server.createStatement();
			
			statement.executeUpdate("delete from users where id = " + user.getId());
        } catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
