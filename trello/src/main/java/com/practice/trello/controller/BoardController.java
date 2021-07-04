package com.practice.trello.controller;

import com.practice.trello.model.Board;
import com.practice.trello.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.rmi.NoSuchObjectException;

@RestController
public class BoardController {

    @Autowired
    BoardService boardService;

    @PostMapping("/createBoard")
    public String createBoard(@RequestBody Board board){
        boardService.createBoard(board);

        return String.format("Board Created: %d", board.getBoardId());
    }

    @GetMapping("/getBoard")
    public Board getBoard(@RequestParam Integer boardId){

        Board board =  boardService.getBoard(boardId);
        return board;
//        if(board != null) {
//            return board.toString();
//        }
//        else{
//            return "No Board Found";
//        }
    }

    @GetMapping("/deleteBoard")
    public String deleteBoard(@RequestParam Integer boardId){

        // todo delete all task lists
        boardService.deleteBoard(boardId);
        return String.format("Board deleted %d", boardId);
    }

    @GetMapping("/addBoardMember")
    public String addBoardMember(@RequestParam Integer boardId, @RequestParam Integer userId){


        boardService.addMember(boardId, userId);
        return String.format("%d Member Added to board %d", userId, boardId);
    }

    @GetMapping("/removeBoardMember")
    public String removeBoardMember(@RequestParam Integer boardId, @RequestParam Integer userId){

        boardService.removeMember(boardId, userId);
        return String.format("%d Member removed from board %d", userId, boardId);
    }
}
