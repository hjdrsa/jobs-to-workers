package com.henry.davis.jobs.to.workers.worker;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.henry.davis.jobs.to.workers.address.Address;
import com.henry.davis.jobs.to.workers.availability.Availability;
import com.henry.davis.jobs.to.workers.name.Name;
import lombok.*;

import java.util.HashSet;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class Worker {

    @JsonProperty("userId")
    private Long id;

    @JsonProperty("rating")
    private int rating;

    @JsonProperty("isActive")
    private boolean isActive;

    @JsonProperty("certificates")
    private HashSet<String> certificates;

    @JsonProperty("skills")
    private HashSet<String> skills;

    @JsonProperty("jobSearchAddress")
    private Address jobSearchAddress;

    @JsonProperty("transportation")
    private String transportation;

    @JsonProperty("hasDriversLicense")
    private boolean hasDriversLicense;

    @JsonProperty("availability")
    private List<Availability> availability;

    @JsonProperty("phone")
    private String phone;

    @JsonProperty("email")
    private String email;

    @JsonProperty("name")
    private Name name;

    @JsonProperty("age")
    private int age;

    @JsonProperty("guid")
    private String guid;
}
