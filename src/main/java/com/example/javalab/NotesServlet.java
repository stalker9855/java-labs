package com.example.javalab;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(value = "/notes")
public class NotesServlet extends HttpServlet {
    private List<String> notes = new ArrayList<>();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<body><html>");
        out.println("<h2>Notes</h2>");
        out.println("<form method='POST' action='notes'>");
        out.println("Note: <input type='text' name='note'/>");
        out.println("<input type='submit' value='Add Note' />");
        out.println("</form>");
        out.println("<ul>");
        for (String note : notes) {
            out.println("<li>" + note + "</li>");
        }
        out.println("</ul>");
        out.println("<a href='/java'>Main</a>");
        out.println("</body></html>");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String note = request.getParameter("note");
        if(note != null && !note.trim().isEmpty()) {
            notes.add(note);
        }

        response.sendRedirect("notes");
    }
}
