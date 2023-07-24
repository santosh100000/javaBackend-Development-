package io.bootify.vsit_managment_system.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;


public class VisitDTO {

    private Long id;

    @NotNull
    @Size(max = 255)
    private String status;

    @NotNull
    private LocalDateTime inTime;

    @NotNull
    private LocalDateTime outTime;

    @Size(max = 255)
    private String purpose;

    @NotNull
    @Size(max = 255)
    private String imageUrl;

    @NotNull
    private Integer numOfPeople;

    private Long visitor;

    private Long flat;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

    public LocalDateTime getInTime() {
        return inTime;
    }

    public void setInTime(final LocalDateTime inTime) {
        this.inTime = inTime;
    }

    public LocalDateTime getOutTime() {
        return outTime;
    }

    public void setOutTime(final LocalDateTime outTime) {
        this.outTime = outTime;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(final String purpose) {
        this.purpose = purpose;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(final String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getNumOfPeople() {
        return numOfPeople;
    }

    public void setNumOfPeople(final Integer numOfPeople) {
        this.numOfPeople = numOfPeople;
    }

    public Long getVisitor() {
        return visitor;
    }

    public void setVisitor(final Long visitor) {
        this.visitor = visitor;
    }

    public Long getFlat() {
        return flat;
    }

    public void setFlat(final Long flat) {
        this.flat = flat;
    }

}
