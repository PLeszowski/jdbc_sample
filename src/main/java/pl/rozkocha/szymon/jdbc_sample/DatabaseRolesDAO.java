package pl.rozkocha.szymon.jdbc_sample;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseRolesDAO implements RolesDAO {
	private static DatabaseRolesDAO instance = null;
	
	public static void init(DatabaseServer server) {
		if(instance == null) {
			instance = new DatabaseRolesDAO(server);
		}
	}
	
	public static DatabaseRolesDAO getInstance() {
		return instance;
	}
	
	public static final String ID_COLUMN = "id";
	public static final String NAME_COLUMN = "name";
	
	public static final String GET_ALL_SQL = "select * from roles;";
	
	private DatabaseServer server;
	
	private DatabaseRolesDAO(DatabaseServer server) {
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
	
	public List<Role> get() {
		List<Role> roles = new ArrayList<>();
		
		Statement statement = null;
        try {
			statement = server.createStatement();
			
			ResultSet resultSet = statement.executeQuery(GET_ALL_SQL);
			
			while(resultSet.next()) {
				int id = resultSet.getInt(resultSet.findColumn(ID_COLUMN));
				String name = resultSet.getString(resultSet.findColumn(NAME_COLUMN));
				
				roles.add(new Role(id, name));
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
		return roles;
	}

	public void add(Role role) {
		Statement statement = null;
        try {
			statement = server.createStatement();
			
			statement.executeUpdate("insert into roles (name) values (\"" +
					role.getName() + "\");");
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

	public void update(Role role) {
		Statement statement = null;
        try {
			statement = server.createStatement();
			
			statement.executeUpdate("update roles set name = \"" + role.getName() + 
					"\" where id = " + role.getId());
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

	public void delete(Role role) {
		Statement statement = null;
        try {
			statement = server.createStatement();
			
			statement.executeUpdate("delete from roles where id = " + role.getId());
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
