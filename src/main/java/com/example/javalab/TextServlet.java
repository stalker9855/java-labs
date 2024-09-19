package com.example.javalab;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/text")
public class TextServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Text Processor</h1>");
        out.println("<form method='post' action='text'>");
        out.println("Enter Text: <input type='text' name='text'><br>");
        out.println("<input type='submit' value='Submit'>");
        out.println("</form>");
        out.println("<a href='/java'>Main</a>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String text = request.getParameter("text");
        PrintWriter out = response.getWriter();

        response.setContentType("text/html;charset=UTF-8");
        out.println("<html><body>");
        out.println("<h1>Processed Text</h1>");
        out.println("<p>Entered Text: " + text + "</p>");
        out.println("<a href='text'>Back</a>");
        out.println("<a href='/java'>Main</a>");
        out.println("</body></html>");
    }
}
