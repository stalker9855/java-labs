package com.example.javalab;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;

@WebServlet(value = "/sort-servlet")
public class SortServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Random random = new Random();
        int[] randomNumbers = new int[10];
        for (int i = 0; i < randomNumbers.length; i++) {
            randomNumbers[i] = random.nextInt(100);
        }
        HttpSession session = request.getSession();
        session.setAttribute("randomNumbers", randomNumbers);
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<p>" + Arrays.toString(randomNumbers) + "</p>");
        out.println("<form method='POST' action='/java/sort-servlet'>");
        out.println("<input type='submit' value='Sort'>");
        out.println("<a href='/java'>Main</a>");
        out.println("</form>");
        out.println("</body></html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int[] randomNumbers = (int[]) session.getAttribute("randomNumbers");
        Arrays.sort(randomNumbers);
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<p>" + Arrays.toString(randomNumbers) + "</p>");
        out.println("<a href='/java'>Main</a>");
        out.println("</body></html>");
    }
}
