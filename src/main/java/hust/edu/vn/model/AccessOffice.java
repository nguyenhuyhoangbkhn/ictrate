package hust.edu.vn.model;

public class AccessOffice {
	private Integer id;
	private String id_user;
	private String id_office;
	private String note;
	
	public AccessOffice(String id_user,String id_office,String note){
		this.id_user = id_user;
		this.id_office = id_office;
		this.note = note;
	}
	public AccessOffice(Integer id,String id_user,String id_office,String note){
		this.id = id;
		this.id_user = id_user;
		this.id_office = id_office;
		this.note = note;
	}
	
	public AccessOffice(){
		
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getId_user() {
		return id_user;
	}
	public void setId_user(String id_user) {
		this.id_user = id_user;
	}
	public String getId_office() {
		return id_office;
	}
	public void setId_office(String id_office) {
		this.id_office = id_office;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
}
