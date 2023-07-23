package com.henry.davis.jobs.to.workers.availability;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Availability {
    @JsonProperty("title")
    private String title;

    @JsonProperty("dayIndex")
    private int dayIndex;
}
