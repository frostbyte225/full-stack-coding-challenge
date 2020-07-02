package com.ibm.fscc.loginservice.services;

import com.ibm.fscc.loginservice.shared.LoginDto;

public interface LoginService {

	public LoginDto getLogin(String email);
	
}
