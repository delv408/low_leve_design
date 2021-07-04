package com.practice.trello.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class TaskList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int listId;

    private String name;

    @ManyToOne
    private Board board;

    @OneToMany(mappedBy = "list")
    private List<Card> cards;
}
