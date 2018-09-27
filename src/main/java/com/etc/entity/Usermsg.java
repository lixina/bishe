package com.etc.entity;

public class Usermsg {
  private int userid;
  private String username;
  private String userpwd;
  private String userphone;
  private String useraddress;
public int getUserid() {
	return userid;
}
public void setUserid(int userid) {
	this.userid = userid;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getUserpwd() {
	return userpwd;
}
public void setUserpwd(String userpwd) {
	this.userpwd = userpwd;
}
public String getUserphone() {
	return userphone;
}
public void setUserphone(String userphone) {
	this.userphone = userphone;
}
public String getUseradress() {
	return useraddress;
}
public void setUseradress(String useradress) {
	this.useraddress = useradress;
}
@Override
public String toString() {
	return "Usermsg [userid=" + userid + ", username=" + username
			+ ", userpwd=" + userpwd + ", userphone=" + userphone
			+ ", useradress=" + useraddress + "]";
}
  public Usermsg() {
	// TODO Auto-generated constructor stub
}
public Usermsg(int userid, String username, String userpwd, String userphone,
		String useraddress) {
	super();
	this.userid = userid;
	this.username = username;
	this.userpwd = userpwd;
	this.userphone = userphone;
	this.useraddress = useraddress;
}
  
}
