package com.bus_reservation_project.payload;

import java.util.List;

public class RouteResponse {
    private List<RouteDTO> routes;
    private String message;

    public RouteResponse(List<RouteDTO> routes, String message) {
        this.routes = routes;
        this.message = message;
    }

    public RouteResponse() {
    }

    public List<RouteDTO> getRoutes() {
        return routes;
    }

    public void setRoutes(List<RouteDTO> routes) {
        this.routes = routes;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
