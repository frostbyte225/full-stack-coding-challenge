package com.fscc.registrationservice.service;

public interface EmployeeConsumer {

    public void consume(String message) throws Exception;

}
