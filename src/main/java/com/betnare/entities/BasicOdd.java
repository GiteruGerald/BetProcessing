package com.betnare.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class BasicOdd {
    @JsonProperty("away_odd")
    private String awayOdd;

    @JsonProperty("away_odd_active")
    private Integer awayOddActive;

    @JsonProperty("neutral_odd")
    private String neutralOdd;

    @JsonProperty("neutral_odd_active")
    private Integer neutralOddActive;

    @JsonProperty("home_odd")
    private String homeOdd;

    @JsonProperty("home_odd_active")
    private Integer homeOddActive;


}
