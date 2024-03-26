package db;

import entities.*;

import org.hibernate.*;
import org.hibernate.boot.*;
import org.hibernate.boot.registry.*;

import java.sql.SQLException;

public class ConnectionManager {
    public static Session connect() {
        try {
            StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .configure("hibernate.cfg.xml")
                    .build();

            Metadata metadata = new MetadataSources(serviceRegistry)
//                    .addAnnotatedClass(Car.class)
                    .addAnnotatedClass(Owner.class)
                    .addAnnotatedClass(License.class)
                    .addAnnotatedClass(Car.class)
                    .addAnnotatedClass(Tag.class)
                    .getMetadataBuilder()
                    .build();

            try {
                SessionFactory sessionFactory = metadata
                        .getSessionFactoryBuilder()
                        .build();

                return sessionFactory.openSession();
            } catch (SessionException e) {
                throw new RuntimeException(e);
            }
        } catch (SessionException e) {
            throw new RuntimeException(e);
        }
    }
}
