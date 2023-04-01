package com.hotel.hotel.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.hotel.models.Route;
import com.hotel.hotel.repositories.RouteRepository;

import jakarta.transaction.Transactional;
@Service
@Transactional
public class RouteService {
    @Autowired
    private RouteRepository routeRepository;

    public List<Route> getAllRoutes() {
        return routeRepository.findAll();
    }

    public Route getRouteById(Long id) {
        return routeRepository.findById(id).orElse(null);
    }

    public Route createRoute(Route route) {
        return routeRepository.save(route);
    }

    public Route updateRoute(Long id, Route routeToUpdate) {
        Route route = routeRepository.findById(id).orElse(null);
        if (route != null) {
            route.setOrigin(routeToUpdate.getOrigin());
            route.setDestination(routeToUpdate.getDestination());
            return routeRepository.save(route);
        }
        return null;
    }

    public void deleteRoute(Long id) {
        routeRepository.deleteById(id);
    }
}
