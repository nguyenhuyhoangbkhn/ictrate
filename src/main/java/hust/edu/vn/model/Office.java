package hust.edu.vn.model;

public class Office {
	Integer id;
	String name;
	String phone;
	String profile;
	String location;
	String type_office;
	Integer flag_delete;
	String mark;

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public Office() {

	}

	public Office(Integer id, String name ,String phone, String profile, String location, String type_office, Integer flag_delete) {
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.profile = profile;
		this.location = location;
		this.type_office = type_office;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getType_office() {
		return type_office;
	}

	public void setType_office(String type_office) {
		this.type_office = type_office;
	}
	
	public Integer getFlag_delete() {
		return flag_delete;
	}

	public void setFlag_delete(Integer flag_delete) {
		this.flag_delete = flag_delete;
	}

	@Override
	public String toString() {
		return "ID=" + id + ",NAME=" + name + ",PHONE=" + phone + ",PROFILE=" + profile;
	}
	
}
