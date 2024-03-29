package com.betnare.repositories;

import com.betnare.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GameRepository extends JpaRepository<Game, Integer> {

    List<Game> findAllByMatchId(Integer matchId);

    Optional<Game> findByGameId(String gameId);
}
