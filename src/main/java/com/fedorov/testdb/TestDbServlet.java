package com.fedorov.testdb;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //setup connection

        //get connection to database


        PrintWriter out = response.getWriter();

        try {
            out.println("Connecting to database: ...");
            Class.forName("org.postgresql.Driver");
            out.println("Driver registration success!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            out.println("Try to get connection...");
            Connection connection =
                    DriverManager.getConnection("jdbc:postgresql://localhost:5432/web_customer_tracker", "kajuga", "sashok");
            out.println("SUCCESS!!!");
            connection.close();

        } catch (SQLException exc) {
            exc.printStackTrace();
            throw new ServletException(exc);
        }
    }
    }
