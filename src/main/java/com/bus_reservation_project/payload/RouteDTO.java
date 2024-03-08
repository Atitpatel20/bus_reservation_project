package com.bus_reservation_project.payload;

import java.time.LocalDate;
import java.time.LocalTime;

public class RouteDTO {
    private Long id;
    private String fromLocation;
    private String toLocation;
    private LocalDate fromDate;
    private LocalDate toDate;
    private int totalDuration; // in minutes
    private LocalTime fromTime;
    private LocalTime toTime;
    private long busId;

    public long getBusId() {
        return busId;
    }

    public void setBusId(long busId) {
        this.busId = busId;
    }

    public RouteDTO(Long id, String fromLocation, String toLocation, LocalDate fromDate, LocalDate toDate, int totalDuration, LocalTime fromTime, LocalTime toTime, long busId) {
        this.id = id;
        this.fromLocation = fromLocation;
        this.toLocation = toLocation;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.totalDuration = totalDuration;
        this.fromTime = fromTime;
        this.toTime = toTime;
        this.busId = busId;
    }
    public RouteDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFromLocation() {
        return fromLocation;
    }

    public void setFromLocation(String fromLocation) {
        this.fromLocation = fromLocation;
    }

    public String getToLocation() {
        return toLocation;
    }

    public void setToLocation(String toLocation) {
        this.toLocation = toLocation;
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public void setToDate(LocalDate toDate) {
        this.toDate = toDate;
    }

    public int getTotalDuration() {
        return totalDuration;
    }

    public void setTotalDuration(int totalDuration) {
        this.totalDuration = totalDuration;
    }

    public LocalTime getFromTime() {
        return fromTime;
    }

    public void setFromTime(LocalTime fromTime) {
        this.fromTime = fromTime;
    }

    public LocalTime getToTime() {
        return toTime;
    }

    public void setToTime(LocalTime toTime) {
        this.toTime = toTime;
    }
}
