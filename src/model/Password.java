package model;

public class Password {
	private String passwordTitle;
	private String passwordValue;

	public Password(String passwordTitle, String passwordValue) {
		super();
		this.passwordTitle = passwordTitle;
		this.passwordValue = passwordValue;
	}

	public String getPasswordTitle() {
		return passwordTitle;
	}

	public void setPasswordTitle(String passwordTitle) {
		this.passwordTitle = passwordTitle;
	}

	public String getPasswordValue() {
		return passwordValue;
	}

	public void setPasswordValue(String passwordValue) {
		this.passwordValue = passwordValue;
	}

}
