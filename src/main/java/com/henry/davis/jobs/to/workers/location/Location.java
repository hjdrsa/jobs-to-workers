package com.henry.davis.jobs.to.workers.location;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public class Location {

    @JsonProperty("longitude")
    private BigDecimal longitude;

    @JsonProperty("latitude")
    private BigDecimal latitude;
}
