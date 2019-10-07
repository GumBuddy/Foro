package Model.Hibernate_Model;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    /*SF=Session Factory */
    private static final SessionFactory SF;

    static {
        try {
            SF = new Configuration().configure().buildSessionFactory();
        } catch (HibernateException HE) {
            System.err.println("Error de inicializacion de SF" + HE);
            throw new ExceptionInInitializerError(HE);
        }
    }

    public static SessionFactory getSf() {
        return SF;
    }
}