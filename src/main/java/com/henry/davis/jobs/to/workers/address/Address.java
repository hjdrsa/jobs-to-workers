package com.henry.davis.jobs.to.workers.address;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class Address {
    @JsonProperty("unit")
    private String unit;

    @JsonProperty("maxJobDistance")
    private int maxJobDistance;

    @JsonProperty("longitude")
    private BigDecimal longitude;

    @JsonProperty("latitude")
    private BigDecimal latitude;
}
