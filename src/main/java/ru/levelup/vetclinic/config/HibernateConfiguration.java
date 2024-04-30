package ru.levelup.vetclinic.config;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.Properties;

public class HibernateConfiguration {
    private static SessionFactory factory;

    public static void initializeSessionFactory() {
        if (factory != null) {
            throw new RuntimeException("SessionFactory has been already initialized");
        }

        Properties properties = new Properties();
        properties.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
        properties.setProperty("hibernate.connection.url", "jdbc:postgresql://127.0.0.1:5432/vet-clinic");
        properties.setProperty("hibernate.connection.username", "postgres");
        properties.setProperty("hibernate.connection.password", "23472");

        properties.setProperty("hibernate.show_sql", "true");
        properties.setProperty("hibernate.format_sql", "true");

        properties.setProperty("hibernate.hbm2ddl.auto", "validate");

        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .applySettings(properties)
                .build();

        Configuration configuration = new Configuration();



        factory = configuration.buildSessionFactory(registry);

    }

    public static SessionFactory getFactory() {
        return factory;
    }
}

