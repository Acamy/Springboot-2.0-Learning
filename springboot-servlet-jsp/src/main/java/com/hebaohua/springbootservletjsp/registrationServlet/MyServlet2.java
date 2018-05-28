package com.hebaohua.springbootservletjsp.registrationServlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

public class MyServlet2 extends HttpServlet {
    String value;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        ServletContext context = getServletContext();
        context.log("init2 has been executed...");

        value = config.getInitParameter("paramName2");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Writer writer = resp.getWriter();

        ServletContext context = getServletContext();
        context.log("doGet2 has been executed...");

        writer.write("<html><body>Hello, " + value + "</body></html>");
    }

    @Override
    public void destroy() {
        ServletContext context = getServletContext();
        context.log("destroy2 has been executed...");
    }
}
