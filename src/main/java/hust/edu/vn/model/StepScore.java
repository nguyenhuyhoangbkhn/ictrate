package hust.edu.vn.model;

public class StepScore {
	private int id;
	private String name;
	private String note;
	private String detailScore;
	private int flagDelete;
	private String typeScore;

	public StepScore() {

	}

	public StepScore(int id, String name, String note, String detailScore, int flag, String typeScore) {
		this.id = id;
		this.name = name;
		this.note = note;
		this.detailScore = detailScore;
		this.flagDelete = flag;
		this.typeScore = typeScore;
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

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getDetailScore() {
		return detailScore;
	}

	public void setDetailScore(String detailScore) {
		this.detailScore = detailScore;
	}

	public int getFlagDelete() {
		return flagDelete;
	}

	public void setFlagDelete(int flagDelete) {
		this.flagDelete = flagDelete;
	}

	public String getTypeScore() {
		return typeScore;
	}

	public void setTypeScore(String typeScore) {
		this.typeScore = typeScore;
	}

	@Override
	public String toString() {
		return "ID=" + id + ",ten=" + name + ",ghi chu=" + note + "detail Score=" + detailScore +"demo" + typeScore;
	}
}
