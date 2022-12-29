package com.betnare.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Odd {
    @JsonProperty("under 2.5")
    private ExtraOdd underTwoFive;

    @JsonProperty("over 2.5")
    private ExtraOdd overTwoFive;

    @JsonProperty("no")
    private ExtraOdd no;

    @JsonProperty("yes")
    private ExtraOdd yes;
}