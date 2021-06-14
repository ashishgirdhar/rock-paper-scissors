package com.ashish.game.repository;

import com.ashish.game.domain.Game;
import com.ashish.game.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface GameRepository extends JpaRepository<Game, Integer> {
    User findByUserName(String userName);
}
