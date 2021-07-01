package com.practice.trello.service;

import com.practice.trello.model.Board;
import com.practice.trello.model.User;
import org.springframework.stereotype.Service;

@Service
public class BoardService {

    public Board createBoard(Board board){
        // todo add save logic here
        return board;
    }

    public void deleteBoard(Integer boardId){

    }

    public void addMember(User user){

    }

    public void removeMember(){

    }

    public void renameBoard(String newBoardName){

    }

}
