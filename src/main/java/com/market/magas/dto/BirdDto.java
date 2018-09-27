package com.market.magas.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class BirdDto implements Serializable {

    @JsonProperty("pricePerUnit")
    private int pricePerUnit;
    @JsonProperty("bird_weight")
    private int weight;
    @JsonProperty("type_bird")
    private String type;

}
