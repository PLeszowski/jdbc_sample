package pl.rozkocha.szymon.jdbc_sample;

public class User extends Beam{
	private String surname;
	private Role role;

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	public User(int id, String name, String surname) {
		super(id, name);
		this.surname = surname;
		this.role = new Role(1, "null");
	}

	public User(int id, String name, String surname, Role role) {
		super(id, name);
		this.surname = surname;
		this.role = role;
	}
	
	public User() {
		super();
		this.surname = "";
		this.role = new Role();
	}

	@Override
	public String toString() {
		return getId() + " " + getName() + " " + surname + " " + role.getName();
	}
}
