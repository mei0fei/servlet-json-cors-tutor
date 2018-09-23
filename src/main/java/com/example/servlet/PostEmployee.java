package com.example.servlet;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.model.Employee;
import com.google.gson.Gson;

@WebServlet(name = "postemployee", urlPatterns = "/postemployee")
public class PostEmployee extends HttpServlet {
 
    private Gson gson = new Gson();
 
    @Override
    protected void doPost(
      HttpServletRequest request, 
      HttpServletResponse response) throws IOException {
         
    	BufferedReader reader = request.getReader();
    	Gson gson = new Gson();
    	Employee employee = gson.fromJson(reader, Employee.class); 
    	System.out.println(employee);
    }
}
