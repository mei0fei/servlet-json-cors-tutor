package com.example.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.model.Employee;
import com.example.model.Product;
import com.google.gson.Gson;

@WebServlet(name = "products", urlPatterns = "/products")
public class ProductServlet extends HttpServlet {
 
    private Gson gson = new Gson();
 
    @Override
    protected void doPost(
      HttpServletRequest request, 
      HttpServletResponse response) throws IOException {
        
    	//read
    	BufferedReader reader = request.getReader();
    	Gson gson = new Gson();
    	Product product = gson.fromJson(reader, Product.class); 
    	System.out.println(product);
    	
    	//write
    	response.setCharacterEncoding("UTF-8");
    	response.setContentType("application/json");
        
        String jsonString = this.gson.toJson(product);
        System.out.println(jsonString);
        
    	PrintWriter out = response.getWriter();
        
        out.print(jsonString);
        out.flush(); 
        
    }

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}
    
    
    
}
