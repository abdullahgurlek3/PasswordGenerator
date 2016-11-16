package dao;

import org.hibernate.*;

import org.springframework.stereotype.*;

/**
 *
 * @author Abdullah Gürlek <abdullah.gurlek3 at gmail.com>
 * Hibernate için sessionFactory nesnesinin kontrol edildiği sınıf
 */
@Controller
public class MySessionFactory {

    SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory factory) {
        sessionFactory = factory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
