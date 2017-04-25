package hust.edu.vn.model;

public class UserInfo {
 
    private String userName;
    private String password;
    private String enabled;
    private String mail;
    private String imgprofile;
    private Integer role;
    private String telephone;
     
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
 
}