package com.betnare.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GameResult {
    private Integer matchId;

    private String homeTeam;

    private Integer homeTeamScore;

    private String awayTeam;

    private Integer awayTeamScore;
}
