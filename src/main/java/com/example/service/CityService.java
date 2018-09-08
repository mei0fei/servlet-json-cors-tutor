package com.example.service;


import java.util.List;

import com.example.dao.CityDao;
import com.example.dao.ICityDao;
import com.example.model.City;

public class CityService implements ICityService {
    
    ICityDao cityDao;
    
    public CityService() {
        
        cityDao = new CityDao();
    }

    @Override
    public List<City> getCities() {

        return cityDao.findAll();
    }
}