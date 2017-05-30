package hust.edu.vn.model;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class UserInfo {

	private String userName;
	private String password;
	private String enabled;
	private String mail;
	private String imgprofile;
	private String role;
	private String telephone;
	private String dob;
	private String gender;
	private String address;

	private List<MultipartFile> images;

	public UserInfo(String userName, String mail, String imgprofile) {
		this.userName = userName;
		this.mail = mail;
		this.imgprofile = imgprofile;
	}

	public UserInfo(String userName, String password, String mail, String imgprofile, String role, String telephone,
			String dob, String gender, String address) {
		this.userName = userName;
		this.password = password;
		this.mail = mail;
		this.imgprofile = imgprofile;
		this.role = role;
		this.telephone = telephone;
		this.dob = dob;
		this.gender = gender;
		this.address = address;
	}

	public UserInfo(String userName, String mail, String imgprofile, String role) {
		this.userName = userName;
		this.mail = mail;
		this.imgprofile = imgprofile;
		this.role = role;
	}

	public UserInfo() {

	}

	public UserInfo(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEnabled() {
		return enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getImgprofile() {
		return imgprofile;
	}

	public void setImgprofile(String imgprofile) {
		this.imgprofile = imgprofile;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public List<MultipartFile> getImages() {
		return images;
	}

	public void setImages(List<MultipartFile> images) {
		this.images = images;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "NAME=" + userName + ",TYPE=" + mail + ",ID_PARENT=" + role;
	}
}