package com.ibm.fscc.loginservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ibm.fscc.loginservice.data.LoginEntity;

public interface LoginRepository extends JpaRepository<LoginEntity, Long> {

    LoginEntity findByEmail(String email);

}
