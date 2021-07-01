package com.practice.trello.model;

import javax.jws.soap.SOAPBinding;
import java.util.List;

public class Board {

    private int boardId;

    private String name;

    private PrivacyType privacy;

    private String url;

    private List<User> members;

    private List<TaskList> lists;

}
