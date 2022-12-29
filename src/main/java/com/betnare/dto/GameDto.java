package com.betnare.dto;

import com.betnare.configs.JsonDeserializer;
import com.betnare.entities.AdvancedOdd;
import com.betnare.entities.BasicOdd;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GameDto {
    @JsonProperty("game_id")
    private String gameId;

    @JsonProperty("home_team")
    private String homeTeam;

    @JsonProperty("competition_name")
    private String competitionName;

    @JsonProperty("away_team")
    private String awayTeam;

    @JsonProperty("sport_name")
    private String sportName;

    @JsonProperty("sport_id")
    private Integer sportId;

    @JsonProperty("side_bets")
    private String sideBets;

    @JsonProperty("category")
    private String category;

    @JsonProperty("odds")
    @JsonDeserialize(using = JsonDeserializer.class)
    private String odds;

    @JsonProperty("extra_odds")
    @JsonDeserialize(using = JsonDeserializer.class)
    private String extraOdds;

    @JsonProperty("special_bet_value")
    private String specialBetValue;

    @JsonProperty("match_id")
    private Integer matchId;

    @JsonProperty("parent_match_id")
    private Integer parentMatchId;

    @JsonProperty("sub_type_id")
    private String subTypeId;

    @JsonProperty("start_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime startTime;

    @JsonProperty("market_name")
    private String marketName;

    @JsonProperty("market_active")
    private Integer marketActive;

    @JsonProperty("match_time")
    private String matchTime;

    @JsonProperty("priority")
    private Integer priority;
}
