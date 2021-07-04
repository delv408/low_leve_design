package com.practice.trello.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.jws.soap.SOAPBinding;
import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter @Setter @NoArgsConstructor
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int boardId;

    private String name;

    private PrivacyType privacy;

    private String url;

    @ManyToMany
    private Set<User> members;

    @OneToMany(mappedBy = "board")
    private List<TaskList> lists;

    public void addMember(User user) {
        if(members == null){
            members = new HashSet<>();
        }
        members.add(user);
    }

    public void removeMember(User user) {
        members.remove(user);
    }

    @Override
    public String toString(){
        return "[BoardId=" + boardId + " Name=" + name + " Url=" + url + "]";
    }
}
