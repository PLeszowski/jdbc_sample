package pl.rozkocha.szymon.jdbc_sample;

import java.util.List;

public interface UsersDAO {
	List<User> get();
	void add(User user);
	void update(User user);
	void delete(User user);
}