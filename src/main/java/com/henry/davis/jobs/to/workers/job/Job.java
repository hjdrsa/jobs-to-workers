package com.henry.davis.jobs.to.workers.job;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.henry.davis.jobs.to.workers.location.Location;
import lombok.*;

import java.time.LocalDateTime;
import java.util.HashSet;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class Job {

    @JsonProperty("jobId")
    private Long id;
    @JsonProperty("driverLicenseRequired")
    private Boolean driverLicenseRequired;
    @JsonProperty("requiredCertificates")
    private HashSet<String> certificates;
    @JsonProperty("location")
    private Location location;
    @JsonProperty("billRate")
    private String billRate;
    @JsonProperty("workersRequired")
    private Integer WorkersRequired;
    @JsonProperty("startDate")
    private LocalDateTime startDate;
    @JsonProperty("about")
    private String about;
    @JsonProperty("jobTitle")
    private String title;
    @JsonProperty("company")
    private String company;
    @JsonProperty("guid")
    private String guid;
}
