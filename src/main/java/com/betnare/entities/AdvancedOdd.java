package com.betnare.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AdvancedOdd {
    @JsonProperty("Total")
    private Odd total;

    @JsonProperty("Both teams to score")
    private Odd bothTeamsToScore;
}
