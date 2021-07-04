package com.practice.trello.controller;

import com.practice.trello.model.TaskList;
import com.practice.trello.service.TaskListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TaskListController {

    @Autowired
    TaskListService taskListService;

    @PostMapping("/createList")
    public TaskList createList(@RequestBody TaskList list, @RequestParam Integer boardId){
        taskListService.addTaskList(list, boardId);
        return list;
    }

    @GetMapping("/deleteList")
    public String deleteList(@RequestParam Integer taskListId){
        taskListService.removeTaskList(taskListId);
        return String.format("Deleted TaskList: %d", taskListId);
    }
}
