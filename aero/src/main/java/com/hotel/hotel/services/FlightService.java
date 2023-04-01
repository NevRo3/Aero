package com.hotel.hotel.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.hotel.models.Flight;
import com.hotel.hotel.repositories.FlightRepository;

import jakarta.transaction.Transactional;
@Service
@Transactional
public class FlightService {
    @Autowired
    private FlightRepository flightRepository;

    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    public Flight getFlightById(Long id) {
        return flightRepository.findById(id).orElse(null);
    }

    public Flight createFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    public Flight updateFlight(Long id, Flight flightToUpdate) {
        Flight flight = flightRepository.findById(id).orElse(null);
        if (flight != null) {
            flight.setAirline(flightToUpdate.getAirline());
            flight.setOrigin(flightToUpdate.getOrigin());
            flight.setDestination(flightToUpdate.getDestination());
            flight.setDepartureTime(flightToUpdate.getDepartureTime());
            flight.setArrivalTime(flightToUpdate.getArrivalTime());
            return flightRepository.save(flight);
        }
        return null;
    }

    public void deleteFlight(Long id) {
        flightRepository.deleteById(id);
    }
}