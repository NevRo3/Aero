package com.hotel.hotel.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.hotel.models.City;
import com.hotel.hotel.repositories.CityRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CityService {
    @Autowired
    private CityRepository cityRepository;

    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    public City getCityById(Long id) {
        return cityRepository.findById(id).orElse(null);
    }

    public City createCity(City city) {
        return cityRepository.save(city);
    }

    public City updateCity(Long id, City cityToUpdate) {
        City city = cityRepository.findById(id).orElse(null);
        if (city != null) {
            city.setName(cityToUpdate.getName());
            return cityRepository.save(city);
        }
        return null;
    }

    public void deleteCity(Long id) {
        cityRepository.deleteById(id);
    }
}
