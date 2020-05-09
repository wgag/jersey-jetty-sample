package com.example;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.servlet.ServletContainer;

import java.net.URI;
import java.net.URL;

public class Main {
    public static void main(String[] args) {
        new Main().run();
    }

    public void run() {
        Server server = null;
        try {
            URL resourceBase = this.getClass().getResource("/webroot");
            ServletContextHandler context =
                    new ServletContextHandler(ServletContextHandler.SESSIONS);
            context.setContextPath("/");
            context.setResourceBase(resourceBase.toString());

            server = new Server(8080);
            server.setHandler(context);

            ServletHolder defaultServletHolder = new ServletHolder("default", DefaultServlet.class);
            context.addServlet(defaultServletHolder, "/*");

            ServletHolder jerseyServletHolder = new ServletHolder("jersey", ServletContainer.class);
            context.addServlet(jerseyServletHolder, "/api/*");
            jerseyServletHolder.setInitParameter("jersey.config.server.provider.packages",
                    "com.example.rest");

            server.start();
            server.join();
        } catch (Exception e) {
            new RuntimeException(e);
        } finally {
            if (server != null) {
                server.destroy();
            }
        }
    }
}
