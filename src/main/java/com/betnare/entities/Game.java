package com.betnare.entities;

import com.betnare.configs.JsonDeserializer;
import com.betnare.dto.GameDto;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;


@Table
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Game {
    @Id
    private String gameId;

    private String homeTeam;

    private String awayTeam;

    private Integer sportId;

    private String sportName;

    private String sideBets;

    private String category;

    @Column(name = "odds", columnDefinition = "json")
    @JsonDeserialize(using = JsonDeserializer.class)
    private String odds;

    @Column(name = "extraOdds", columnDefinition = "json")
    @JsonDeserialize(using = JsonDeserializer.class)
    private String extraOdds;

    private String specialBetValue;

    private String subTypeId;

    private Integer matchId;

    private Integer parentMatchId;

    private LocalDateTime startTime;

    private String marketName;

    private Integer marketActive;

    private String matchTime;

    private Integer priority;


    public Game(GameDto dto) {
        setGameId(dto.getGameId());
        setHomeTeam(dto.getHomeTeam());
        setAwayTeam(dto.getAwayTeam());
        setSportId(dto.getSportId());
        setSportName(dto.getSportName());
        setSideBets(dto.getSideBets());
        setCategory(dto.getCategory());
        setOdds(dto.getOdds());
        setExtraOdds(dto.getExtraOdds());
        setSpecialBetValue(dto.getSpecialBetValue());
        setSubTypeId(dto.getSubTypeId());
        setStartTime(dto.getStartTime());
        setMatchId(dto.getMatchId());
        setParentMatchId(dto.getParentMatchId());
        setMarketName(dto.getMarketName());
        setMarketActive(dto.getMarketActive());
        setMatchTime(dto.getMatchTime());
        setPriority(dto.getPriority());
    }
}
