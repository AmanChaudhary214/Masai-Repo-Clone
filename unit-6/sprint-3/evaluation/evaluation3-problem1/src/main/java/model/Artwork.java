package model;

public class Artwork {

	private int id;
	private String name;
	private int creationTime;
	
	public Artwork(int id, String name, int creationTime) {
		super();
		this.id = id;
		this.name = name;
		this.creationTime = creationTime;
	}

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

	public int getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(int creationTime) {
		this.creationTime = creationTime;
	}

	@Override
	public String toString() {
		return "Artwork [id=" + id + ", name=" + name + ", creationTime=" + creationTime + "]";
	}
    
}
