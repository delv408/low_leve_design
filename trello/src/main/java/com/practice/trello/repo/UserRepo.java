package com.practice.trello.repo;

import com.practice.trello.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepo extends JpaRepository<User, Integer> {
    @Query(value = "Select u from User u where u.userId = :memberId")
    User getByUserId(Integer memberId);
}
