package pl.rozkocha.szymon.jdbc_sample;

import java.util.List;

public interface IDAO<T extends Object> {
	List<T> get();
	void add(T beam);
	void update(T beam);
	void delete(T beam);
}