package com.practice.trello.repo;

import com.practice.trello.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepo extends JpaRepository<Card, Integer> {
}
