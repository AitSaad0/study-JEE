package com.example.banqueproject.listener;

import com.example.banqueproject.dao.DBConnection;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

public class AppListener  implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        DBConnection.init();
        System.out.println("Application started");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        DBConnection.close();
        System.out.println("Application stopped");
    }

}
