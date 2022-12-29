package com.betnare.entities;

import com.betnare.enums.BetOdds;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Collection;

@Data
@NoArgsConstructor
@Entity
public class Bet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String gameId;

    @ElementCollection(targetClass = BetOdds.class)
    @CollectionTable
    @Enumerated(EnumType.STRING)
    private Collection<BetOdds> oddPicks;

    private BigDecimal amount;
}
