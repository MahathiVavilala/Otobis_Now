package com.talentsprint.otobisnow.bean;

public class Route {
    private int routeId;
    private int sourceId;
    private int destinationId;
    private String source;
    private String destination;
    private String isAvailable;
    private String busNo;

    public Route() {
    }

    public int getRouteId() {
        return this.routeId;
    }

    public void setRouteId(int routeId) {
        this.routeId = routeId;
    }

    public int getSourceId() {
        return this.sourceId;
    }

    public void setSourceId(int sourceId) {
        this.sourceId = sourceId;
    }

    public int getDestinationId() {
        return this.destinationId;
    }

    public void setDestinationId(int destinationId) {
        this.destinationId = destinationId;
    }

    public String getSource() {
        return this.source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return this.destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getIsAvailable() {
        return this.isAvailable;
    }

    public void setIsAvailable(String isAvailable) {
        this.isAvailable = isAvailable;
    }

    public String getBusNo() {
        return this.busNo;
    }

    public void setBusNo(String busNo) {
        this.busNo = busNo;
    }
}
