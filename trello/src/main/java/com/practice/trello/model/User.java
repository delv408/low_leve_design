package com.practice.trello.model;

import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter @NoArgsConstructor
public class User implements Comparable<User>{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    private String name;
    private String email;

    public int compareTo(User user2) {
        return email.compareTo(user2.email);
    }


}
