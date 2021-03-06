package com.example.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.model.City;
import com.example.service.CityService;
import com.example.util.JsonConverter;

@WebServlet(name = "GetCities", urlPatterns = {"/GetCities"})
public class GetCities extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("application/json;charset=UTF-8");

        ServletOutputStream out = response.getOutputStream();

        List<City> cities = new CityService().getCities();

        JsonConverter converter = new JsonConverter();
        String output = converter.convertToJson(cities);

        out.print(output);
    }
}