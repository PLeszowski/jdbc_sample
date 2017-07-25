package pl.rozkocha.szymon.jdbc_sample;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	
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
	
	private String surname;
	@ManyToOne
    @JoinColumn(name = "role_id")
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
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.role = new Role(1, "null");
	}

	public User(int id, String name, String surname, Role role) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.role = role;
	}
	
	public User() {
		this.id = 0;
		this.name = "";
		this.surname = "";
		this.role = new Role();
	}

	@Override
	public String toString() {
		return getId() + " " + getName() + " " + surname + " " + role.getName();
	}
}
