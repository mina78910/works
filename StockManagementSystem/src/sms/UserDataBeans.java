package sms;

import java.io.Serializable;

public class UserDataBeans implements Serializable {


	private int id;
	private String name;
	private String pass;

	public UserDataBeans(){
        this.setId(0);
        this.setName("");
        this.setPass("");
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}


}
