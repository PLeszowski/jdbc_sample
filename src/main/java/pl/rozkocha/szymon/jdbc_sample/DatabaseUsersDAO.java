package pl.rozkocha.szymon.jdbc_sample;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseUsersDAO implements UsersDAO {
	public static final String ID_COLUMN = "id";
	public static final String NAME_COLUMN = "name";
	public static final String SURNAME_COLUMN = "surname";
	
	public static final String GET_ALL_SQL = "select * from users;";
	
	private DatabaseServer server;
	
	public DatabaseUsersDAO(DatabaseServer server) {
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
	
	@Override
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
				
				users.add(new User(id, name, surname));
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

	@Override
	public void add(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub

	}

}
