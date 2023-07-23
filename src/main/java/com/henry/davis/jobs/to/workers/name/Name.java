package com.henry.davis.jobs.to.workers.name;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class Name {
    @JsonProperty("last")
    private String last;

    @JsonProperty("first")
    private String first;
}
