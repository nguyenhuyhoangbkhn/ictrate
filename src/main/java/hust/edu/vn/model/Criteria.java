package hust.edu.vn.model;

public class Criteria {
	private Integer id;
	private String name;
	private String note;
	private String type_criteria;
	private String type_score;
	private Integer flag_delete;
	public Criteria(){		
	}	
	public Criteria(Integer id,String name,String note,String type_criteria, String type_score,Integer flag_delete){
		this.id = id;
		this.name = name;
		this.note = note;
		this.type_criteria = type_criteria;
		this.type_score = type_score;
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
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getTypeCriteria() {
		return type_criteria;
	}
	public void setTypeCriteria(String typeCriteria) {
		this.type_criteria = typeCriteria;
	}
	public String getTypeScore() {
		return type_score;
	}
	public void setTypeScore(String typeScore) {
		this.type_score = typeScore;
	}
	public Integer getFlagDelete() {
		return flag_delete;
	}

	public void setFlagDelete(Integer flagDelete) {
		this.flag_delete = flagDelete;
	}
	@Override
	public String toString() {
		return "ID=" + id + ",NAME=" + name + ",TYPE=" + note + "type criteria=" + type_criteria + "type score" + type_score;
	}
}
