package by.tr.task.bean;

import java.util.Objects;

public class User implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	private String userName;
	private String userPassword;
	private boolean signIn;
	

	public User() {
		super();
	}
	public User(String userName, String userPassword) {
		super();
		this.userName = userName;
		this.userPassword = userPassword;
	}
	public boolean isSignIn() {
		return signIn;
	}

	public void setSignIn(boolean signIn) {
		this.signIn = signIn;
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	@Override
	public int hashCode() {
		return Objects.hash(signIn, userName, userPassword);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return signIn == other.signIn && Objects.equals(userName, other.userName)
				&& Objects.equals(userPassword, other.userPassword);
	}

}
