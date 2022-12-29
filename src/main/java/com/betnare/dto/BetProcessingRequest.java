package com.betnare.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BetProcessingRequest {
    private String gameId;
    private GameResult result;
}
