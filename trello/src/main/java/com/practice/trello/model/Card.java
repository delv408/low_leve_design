package com.practice.trello.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.net.UnknownServiceException;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cardId;

    private String name;

    private String description;
    @ManyToOne
    private TaskList list;

    @OneToOne
    private User assignedTo;
}
