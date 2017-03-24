package com.feign.model;

public class Contributor {

	private String login;
	private int contributions;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public int getContributions() {
		return contributions;
	}

	public void setContributions(int contributions) {
		this.contributions = contributions;
	}

	@Override
	public String toString() {
		return String.format("Login: %s | Contributions: %s", this.getLogin(), this.getContributions());
	}

}
