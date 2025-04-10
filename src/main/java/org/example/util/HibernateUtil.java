package org.example.util;


import org.example.entity.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml"); // resources klasöründe olacak
            configuration.addAnnotatedClass(User.class);  // Entity sınıfını tanıt

            return configuration.buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("SessionFactory oluşturulurken hata: " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        getSessionFactory().close();
    }
}
