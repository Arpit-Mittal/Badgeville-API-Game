package net.roseindia.form;

public class playerUserInformation {

	private String domain;
	private String email;
	private String display_name;

	public playerUserInformation(String domain, String email,
			String display_name) {
		this.domain = domain;
		this.email = email;
		this.display_name = display_name;

	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDisplay_name() {
		return display_name;
	}

	public void setDisplay_name(String display_name) {
		this.display_name = display_name;
	}

}
