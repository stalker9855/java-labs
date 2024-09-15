package com.example.javalab;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/bobross")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Bob Ross!!!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body style='height: 100vh; margin: 0;'>");
        out.println("<div style='display: flex; justify-content: center; align-items: center; height: 100%;'>");
        out.println("<h1 style='color: gray;'>" + message + "</h1>");
        out.println("</div>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}