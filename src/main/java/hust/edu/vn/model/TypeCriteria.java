package hust.edu.vn.model;

public class TypeCriteria {
	private Integer id;
	private String name;
	private String note;
	private Integer id_parent;
	private Integer flag_delede;
	
	

	public TypeCriteria(){
		
	}
	
	public TypeCriteria(Integer id, String name, String note, Integer id_parent, Integer flag_delete) {
		this.id = id;
		this.name = name;
		this.note = note;
		this.id_parent = id_parent;
		this.flag_delede = flag_delete;
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
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Integer getId_parent() {
		return id_parent;
	}
	public void setId_parent(Integer id_parent) {
		this.id_parent = id_parent;
	}
	public Integer getFlag_delede() {
		return flag_delede;
	}

	public void setFlag_delede(Integer flag_delede) {
		this.flag_delede = flag_delede;
	}
	@Override
	public String toString() {
		return "ID=" + id + ",NAME=" + name + ",note=" + note + ",ID_PARENT=" + id_parent;
	}
	
}
