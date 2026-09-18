package com.qsp.employee_management_system.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private HibernateUtil() {
    }

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {

        if (sessionFactory == null) {

            Configuration configuration = new Configuration()
                    .configure();

            String dbUrl = System.getenv("DB_URL");
            String dbUsername = System.getenv("DB_USERNAME");
            String dbPassword = System.getenv("DB_PASSWORD");

            if (dbUrl != null && dbUsername != null && dbPassword != null) {

                configuration.setProperty(
                        "hibernate.connection.url",
                        dbUrl
                );

                configuration.setProperty(
                        "hibernate.connection.username",
                        dbUsername
                );

                configuration.setProperty(
                        "hibernate.connection.password",
                        dbPassword
                );
            }

            sessionFactory = configuration.buildSessionFactory();
        }

        return sessionFactory;
    }
}