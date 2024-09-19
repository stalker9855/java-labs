package com.example.javalab;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/calculator")
public class CalculatorServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html;charset=UTF-8");
        out.println("<html><body>");
        out.println("<h1>Calculator</h1>");
        out.println("<form method='post' action='calculator'>");
        out.println("Number 1: <input type='text' name='num1'><br>");
        out.println("Number 2: <input type='text' name='num2'><br>");
        out.println("Operation: ");
        out.println("<select name='operation'>");
        out.println("<option value='add'>Add</option>");
        out.println("<option value='subtract'>Subtract</option>");
        out.println("<option value='multiply'>Multiply</option>");
        out.println("<option value='divide'>Divide</option>");
        out.println("</select><br>");
        out.println("<input type='submit' value='Calculate'>");
        out.println("<a href='/java'>Main</a>");
        out.println("</form>");
        out.println("</body></html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String num1Str = request.getParameter("num1");
        String num2Str = request.getParameter("num2");
        String operation = request.getParameter("operation");

        double num1 = Double.parseDouble(num1Str);
        double num2 = Double.parseDouble(num2Str);
        double result = 0;
        String errorMessage = null;

        switch (operation) {
            case "add":
                result = num1 + num2;
                break;
            case "subtract":
                result = num1 - num2;
                break;
            case "multiply":
                result = num1 * num2;
                break;
            case "divide":
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    errorMessage = "Cannot divide by zero!";
                }
                break;
            default:
                errorMessage = "Invalid operation!";
                break;
        }

        response.setContentType("text/html;charset=UTF-8");
        out.println("<html><body>");
        out.println("<h1>Calculator Result</h1>");
        if (errorMessage != null) {
            out.println("<p>Error: " + errorMessage + "</p>");
        } else {
            out.println("<p>Result: " + result + "</p>");
        }
        out.println("<a href='calculator'>Back</a>");
        out.println("</body></html>");
    }
}
