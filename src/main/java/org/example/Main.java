package org.example;

import org.example.entity.User;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {
    public static void main(String[] args) {
        // Hibernate oturumu başlat
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            // Yeni kullanıcı oluştur
            User user = new User("Ali Veli", "ali@example.com");

            // Veritabanına kaydet
            session.save(user);

            transaction.commit();
            System.out.println("Kullanıcı başarıyla eklendi.");
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
            HibernateUtil.shutdown();
        }
    }
}

