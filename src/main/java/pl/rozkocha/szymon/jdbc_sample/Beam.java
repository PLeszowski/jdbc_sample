package pl.rozkocha.szymon.jdbc_sample;

public class Beam {
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

	public Beam(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public Beam() {
		this.id = 0;
		this.name = "none";
	}
}
