package com.betnare.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class ExtraOdd {
    @JsonProperty("odd_active")
    private Integer oddActive;

    @JsonProperty("market_active")
    private Integer marketActive;

    @JsonProperty("odd_value")
    private String oddValue;

    @JsonProperty("sub_type_id")
    private String subTypeId;

    @JsonProperty("special_bet_value")
    private String specialBetValue;
}
