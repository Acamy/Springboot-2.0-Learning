package com.hebaohua.springbootservletjsp.anotationServlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

@WebServlet(
            name = "myServlet",
            urlPatterns = "/myservlet",
            initParams = @WebInitParam(name = "paramName", value = "paramValue")
)
public class MyServlet extends HttpServlet {
    String value;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        ServletContext context = getServletContext();
        context.log("init has been executed...");

        value = config.getInitParameter("paramName");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Writer writer = resp.getWriter();

        ServletContext context = getServletContext();
        context.log("doGet has been executed...");

        writer.write("<html><body>Hello, " + value + "</body></html>");
    }

    @Override
    public void destroy() {
        ServletContext context = getServletContext();
        context.log("destroy has been executed...");
    }

}
