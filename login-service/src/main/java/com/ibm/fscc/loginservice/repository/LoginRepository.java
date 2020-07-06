package com.ibm.fscc.loginservice.repository;

import org.springframework.data.repository.CrudRepository;

import com.ibm.fscc.loginservice.data.LoginEntity;

public interface LoginRepository extends CrudRepository<LoginEntity, Long> {

}
