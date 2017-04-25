package hust.edu.vn.model;

public class Criteria {
	private Integer id;
	private String name;
	private String note;
	private String type_criteria;
	private String type_score;
	private Integer flag_delete;
	private Float among;
	
	public Criteria(){		
		
	}	

	public Criteria(Integer id,String name,String note,String type_criteria, String type_score,Integer flag_delete, Float among){
		this.id = id;
		this.name = name;
		this.note = note;
		this.type_criteria = type_criteria;
		this.type_score = type_score;
		this.flag_delete = flag_delete;
		this.among = among;
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
	public String getType_criteria() {
		return type_criteria;
	}
	public void setType_criteria(String type_criteria) {
		this.type_criteria = type_criteria;
	}
	public String getType_score() {
		return type_score;
	}
	public void setType_score(String type_score) {
		this.type_score = type_score;
	}
	public Integer getFlag_delete() {
		return flag_delete;
	}
	public void setFlag_delete(Integer flag_delete) {
		this.flag_delete = flag_delete;
	}
	public Float getAmong() {
		return among;
	}

	public void setAmong(Float among) {
		this.among = among;
	}
	@Override
	public String toString() {
		return "ID=" + id + ",NAME=" + name + ",TYPE=" + note + "type criteria=" + type_criteria + "type score" + type_score;
	}

	
}
