package com.fscc.registrationservice.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "employee")
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class EmployeeResponse {

    @Id
    private int id;

    private String firstName;

    private String lastName;

    private String email;

    private String status;

    private Date statusDate;

}
