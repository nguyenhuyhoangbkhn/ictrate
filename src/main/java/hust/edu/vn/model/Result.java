package hust.edu.vn.model;

public class Result {
	private Integer id;
	private String idOffice;
	private String idCriteria;
	private String mark;

	public Result() {

	}

	public Result(Integer id, String idOffice, String idCriteria, String Mark) {
		this.id = id;
		this.idOffice = idOffice;
		this.idCriteria = idCriteria;
		this.mark = Mark;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIdOffice() {
		return idOffice;
	}

	public void setIdOffice(String idOffice) {
		this.idOffice = idOffice;
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
