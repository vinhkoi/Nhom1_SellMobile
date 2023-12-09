package Taikhoan;

public class User {
	private String UserName;
	private String Password;
	private String ID;
	public User() {
		// TODO Auto-generated constructor stub
	}
	public User(String UserName,String Password,String ID) {
		this.UserName = UserName;
		this.Password = Password;
		this.ID = ID;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String UserName) {
		this.UserName = UserName;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String Password) {
		this.Password = Password;
	}
	public String getID() {
		return ID;
	}
	public void setID(String ID) {
		this.ID = ID;
	}
	
}
