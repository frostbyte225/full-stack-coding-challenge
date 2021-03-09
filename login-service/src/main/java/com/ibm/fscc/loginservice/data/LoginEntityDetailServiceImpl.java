package com.ibm.fscc.loginservice.data;

import com.ibm.fscc.loginservice.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class LoginEntityDetailServiceImpl implements UserDetailsService {

    @Autowired
    LoginRepository loginRepository;

    public LoginEntityDetailServiceImpl(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        LoginEntity loginEntity = loginRepository.findByEmail(email);
        if ( loginEntity == null ) {
            throw new UsernameNotFoundException(email);
        }

        return new User(loginEntity.getEmail(), loginEntity.getPassword(), new ArrayList<>());
    }
}
