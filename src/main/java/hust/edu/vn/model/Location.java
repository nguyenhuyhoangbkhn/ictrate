package hust.edu.vn.model;


public class Location {
	Integer id;
	String name;
	String type;
	Integer id_parent;
	Integer flag_delete;

	public Location() {

	}

	public Location(Integer id, String name, String type, Integer id_parent, Integer flag_delete) {
		this.id = id;
		this.name = name;
		this.type = type;
		this.id_parent = id_parent;
		this.flag_delete = flag_delete;

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getId_parent() {
		return id_parent;
	}

	public void setId_parent(Integer id_parent) {
		this.id_parent = id_parent;
	}

	public Integer getFlag_delete() {
		return flag_delete;
	}

	public void setFlag_delete(Integer flag_delete) {
		this.flag_delete = flag_delete;
	}

	@Override
	public String toString() {
		return "ID=" + id + ",NAME=" + name + ",TYPE=" + type + ",ID_PARENT=" + id_parent;
	}
}
