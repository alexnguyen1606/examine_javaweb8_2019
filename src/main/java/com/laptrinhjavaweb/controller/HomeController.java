package com.laptrinhjavaweb.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/trang-chu"})
public class HomeController extends HttpServlet {
    protected void doPost (HttpServletRequest request, HttpServletResponse response)throws SecurityException, IOException {

    }
    protected void doPut (HttpServletRequest request, HttpServletResponse response){

    }
    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/admin/home.jsp");
        requestDispatcher.forward(request,response);
    }
}
