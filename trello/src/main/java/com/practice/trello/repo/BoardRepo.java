package com.practice.trello.repo;

import com.practice.trello.model.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BoardRepo extends JpaRepository<Board, Integer> {

    @Query(value = "Select b from Board b where b.boardId = :boardId")
    Board getByBoardId(Integer boardId);
}
