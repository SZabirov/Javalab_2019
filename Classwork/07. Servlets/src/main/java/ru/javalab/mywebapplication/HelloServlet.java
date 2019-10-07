package ru.javalab.mywebapplication;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        writer.println("<html>" +
                "<body>" +
                "<form action=\"greeting\">" +
                "<input name=\"username\" type=\"text\">" +
                "<input type=\"submit\">" +
                "</form>" +
                "</body>" +
                "</html>");
    }
}
