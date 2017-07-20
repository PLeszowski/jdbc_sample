package pl.rozkocha.szymon.jdbc_sample;

import java.util.List;

public interface RolesDAO {
	List<Role> get();
	void add(Role role);
	void update(Role role);
	void delete(Role role);
}