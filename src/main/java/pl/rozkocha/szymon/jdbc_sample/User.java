package pl.rozkocha.szymon.jdbc_sample;

public class User {
	private int id;
	private String name;
	private String surname;
	private Role role;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

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
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.role = new Role(1, "default");
	}

	public User(int id, String name, String surname, Role role) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.role = role;
	}

	@Override
	public String toString() {
		return id + " " + name + " " + surname + " " + role.getName();
	}
}
