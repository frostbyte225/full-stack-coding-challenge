package com.ibm.fscc.loginservice.services;

import com.ibm.fscc.loginservice.data.LoginEntity;
import com.ibm.fscc.loginservice.repository.LoginRepository;
import com.ibm.fscc.loginservice.shared.LoginDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

	@Autowired
	LoginRepository loginRepository;

	public LoginEntity getLoginByEmail(String email) {
		return loginRepository.findByEmail(email);
	}

}
