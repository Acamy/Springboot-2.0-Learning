package com.hebaohua.springbootservletjsp.registrationServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

public class MyServletRequestListener2 implements ServletRequestListener {
    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();
        ServletContext context = request.getServletContext();
        context.log("requestInitialized2 in Listener...");
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();
        ServletContext context = request.getServletContext();
        context.log("requestDestroyed2 in Listener...");
    }
}
