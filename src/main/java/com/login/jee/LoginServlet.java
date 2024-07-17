package com.login.jee;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

    /*
     * Browser sends Http Request to Web Server
     *
     * Code in Web Server => Input:HttpRequest, Output: HttpResponse
     * JEE with Servlets
     *
     * Web Server responds with Http Response
     */

//Java Platform, Enterprise Edition (Java EE) JEE6

//Servlet is a Java programming language class
//used to extend the capabilities of servers
//that host applications accessed by means of
//a request-response programming model.

//1. extends javax.servlet.http.HttpServlet
//2. @WebServlet(urlPatterns = "/login.do")
//3. doGet(HttpServletRequest request, HttpServletResponse response)
//4. How is the response created?

    @WebServlet(urlPatterns = "/login.do")
    public class LoginServlet extends HttpServlet {

        private UserValidationService service = new UserValidationService();

        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
            //use attribute in js

            request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response);
        }

        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
            //use attribute in jsp


            String attr = request.getParameter("password");
            String nameStr = request.getParameter("getName");
            if (service.isValidUser(nameStr,attr)) {
                request.setAttribute("name", nameStr);
                request.getRequestDispatcher("WEB-INF/views/welcome.jsp").forward(request, response);
            } else {

                request.setAttribute("name", nameStr);
                request.setAttribute("autError","Login or password is incorrect. Please try again");
                request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request, response);
            }

        }

        }

