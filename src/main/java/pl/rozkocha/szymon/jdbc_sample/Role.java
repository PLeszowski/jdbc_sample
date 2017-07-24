package pl.rozkocha.szymon.jdbc_sample;

public class Role extends Bean{
	public Role(int id, String name) {
		super(id, name);
	}
	
	public Role() {
		super();
	}

	@Override
	public String toString() {
		return getId() + " " + getName();
	}
}
