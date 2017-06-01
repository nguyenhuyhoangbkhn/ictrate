package hust.edu.vn.model;

public class CommentJudge {
	private Integer cmtid;
	private String usernameid;
	private Integer officeid;
	private String content;
	private String times;
	private String imgprofile;

	public CommentJudge() {

	}

	public CommentJudge(Integer cmtid, String usernameid, Integer officeid, String content, String times,
			String imgprofile) {
		this.cmtid = cmtid;
		this.usernameid = usernameid;
		this.officeid = officeid;
		this.content = content;
		this.times = times;
		this.imgprofile = imgprofile;
	}

	public Integer getCmtid() {
		return cmtid;
	}

	public void setCmtid(Integer cmtid) {
		this.cmtid = cmtid;
	}

	public String getImgprofile() {
		return imgprofile;
	}

	public void setImgprofile(String imgprofile) {
		this.imgprofile = imgprofile;
	}

	public String getTimes() {
		return times;
	}

	public void setTimes(String times) {
		this.times = times;
	}

	public String getUsernameid() {
		return usernameid;
	}

	public void setUsernameid(String usernameid) {
		this.usernameid = usernameid;
	}

	public Integer getOfficeid() {
		return officeid;
	}

	public void setOfficeid(Integer officeid) {
		this.officeid = officeid;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "ID=" + cmtid+ "NAME=" + usernameid + ",TYPE=" + officeid + ",ID_PARENT=" + content;
	}
}
