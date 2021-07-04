package com.practice.trello.service;

import com.practice.trello.model.Board;
import com.practice.trello.model.TaskList;
import com.practice.trello.repo.BoardRepo;
import com.practice.trello.repo.TaskListRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskListService {

    @Autowired
    TaskListRepo taskListRepo;

    @Autowired
    BoardRepo boardRepo;

    public TaskList addTaskList(TaskList list, Integer boardId){
        Board board = boardRepo.getById(boardId);
        list.setBoard(board);
        taskListRepo.save(list);
        return list;
    }

    public void removeTaskList(Integer taskListId){
        taskListRepo.deleteById(taskListId);
    }


}
