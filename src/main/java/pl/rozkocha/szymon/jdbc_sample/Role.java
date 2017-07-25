package pl.rozkocha.szymon.jdbc_sample;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Role{
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
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "role_id")
	private Set<User> users;

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public Role(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public Role() {
		this.id = 0;
		this.name = "";
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
