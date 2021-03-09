package com.fscc.registrationservice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class EmployeeRequest {

    @Id
    private int id;

    private String firstName;

    private String lastName;

    private String email;

}
