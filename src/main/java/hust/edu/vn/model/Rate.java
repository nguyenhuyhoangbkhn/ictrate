package hust.edu.vn.model;

public class Rate {
	private Integer id;
	private String idAccess;
	private String idCriteria;
	private String mark;
	
	public Rate(){
		
	}
	public Rate(Integer id,String idAccess,String idCriteria,String mark){
		this.id = id;
		this.idAccess = idAccess;
		this.idCriteria = idCriteria;
		this.mark = mark;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getIdAccess() {
		return idAccess;
	}
	public void setIdAccess(String idAccess) {
		this.idAccess = idAccess;
	}
	public String getIdCriteria() {
		return idCriteria;
	}
	public void setIdCriteria(String idCriteria) {
		this.idCriteria = idCriteria;
	}
	public String getMark() {
		return mark;
	}
	public void setMark(String mark) {
		this.mark = mark;
	}
	
}
