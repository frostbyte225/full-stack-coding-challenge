package com.ibm.fscc.loginservice.data;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "login")
@Getter
@Setter
public class LoginEntity {

	@Id
	@Column(name = "email")
	private String email; // primary key

	@Column(name = "password")
	private String password; // encrypted

	public LoginEntity(String email, String password) {
		this.email = email;
		this.password = password;
	}

	public LoginEntity() {
	}
}
