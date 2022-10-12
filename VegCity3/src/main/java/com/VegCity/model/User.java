package com.VegCity.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    public User(String name, String password, String mail) {
        this.mail = mail;
        this.name = name;
        this.password = password;
    }

    private Long id;
    private String name;
    private String password;
    private String mail;

    private List<Recipe> recipe;

}