package com.example.accessingdatajpa;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Member {
    @Id
    private String userId;
    private String password;
    private String name;
    private String regNo;

    public Member() {

    }
}




