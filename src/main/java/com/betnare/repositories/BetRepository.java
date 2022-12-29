package com.betnare.repositories;

import com.betnare.entities.Bet;
import com.betnare.enums.BetOdds;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;


@Repository
public interface BetRepository extends JpaRepository<Bet, Integer> {
    List<Bet> findAllByGameIdAndOddPicksIn(String gameId, Collection<BetOdds> oddPicks);
}
