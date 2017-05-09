package hust.edu.vn.model;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class UserInfo {
 
    private String userName;
    private String password;
    private String enabled;
    private String mail;
    private byte[] imgprofile;
    private Integer role;
    private String telephone;
     
 // Upload file.
    private CommonsMultipartFile fileData;
    
    public UserInfo(String userName, String mail, String telephone) {
		this.userName = userName;
		this.mail = mail;
		this.telephone = telephone;
	}
    
	public UserInfo()  {
         
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

	public byte[] getImgprofile() {
		return imgprofile;
	}

	public void setImgprofile(byte[] imgprofile) {
		this.imgprofile = imgprofile;
	}

	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public CommonsMultipartFile getFileData() {
		return fileData;
	}

	public void setFileData(CommonsMultipartFile fileData) {
		this.fileData = fileData;
	}

	@Override
	public String toString() {
		return "NAME=" + userName + ",TYPE=" + mail + ",ID_PARENT=" + telephone;
	}
}