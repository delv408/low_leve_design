package com.practice.trello.service;

import com.practice.trello.model.Board;
import com.practice.trello.model.PrivacyType;
import com.practice.trello.model.User;
import com.practice.trello.repo.BoardRepo;
import com.practice.trello.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {

    @Autowired
    BoardRepo boardRepo;

    @Autowired
    UserRepo userRepo;

    public Board createBoard(Board board){
        if (board.getPrivacy() == null){
            board.setPrivacy(PrivacyType.PUBLIC);
        }
        boardRepo.save(board);
        return board;
    }

    public void deleteBoard(Integer boardId){
        boardRepo.deleteById(boardId);
    }

    public void addMember(Integer boardId, Integer memberId){
        User user = userRepo.getByUserId(memberId);
        Board board = boardRepo.getByBoardId(boardId);
        board.addMember(user);
        boardRepo.save(board);
    }

    public void removeMember(Integer boardId, Integer memberId){
        User user = userRepo.getByUserId(memberId);
        Board board = boardRepo.getByBoardId(boardId);
        board.removeMember(user);
        boardRepo.save(board);
    }

    public void renameBoard(String newBoardName){

    }

    public Board getBoard(Integer boardId) {
        return boardRepo.getByBoardId(boardId);
    }
}
