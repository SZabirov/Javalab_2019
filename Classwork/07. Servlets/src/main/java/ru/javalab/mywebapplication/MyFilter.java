package ru.javalab.mywebapplication;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class MyFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpReq = (HttpServletRequest) servletRequest;
        String method = httpReq.getMethod();
        File file = new File("myfile.txt");
        PrintWriter pw = new PrintWriter(file);
        pw.println(method);
        pw.flush();
//        HttpServletResponse resp =
//                (HttpServletResponse) servletResponse;
//        PrintWriter respWriter = resp.getWriter();
//        respWriter.println("hey");
        filterChain.doFilter(servletRequest, servletResponse);

    }

    public void destroy() {

    }
}
