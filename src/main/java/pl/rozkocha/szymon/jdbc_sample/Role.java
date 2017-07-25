package pl.rozkocha.szymon.jdbc_sample;

import java.util.Set;

public class Role extends Bean{
	private Set<User> users;

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public Role(int id, String name) {
		super(id, name);
	}
	
	public Role() {
		super();
	}

	@Override
	public String toString() {
		String text = getId() + " " + getName() + ", users: ";
		
		for(User user : users) {
			text += user.toString() + ", ";
		}
		
		return text;
	}
}
