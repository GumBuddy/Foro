package Model.DAO;

import Model.Hibernate_Model.HibernateUtil;
import Model.Beans.Participante_Bean;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class Participante_DAO {


    private Session session;
    private Transaction transaction;

    private void StartOperation() throws HibernateException {
        session = HibernateUtil.getSf().openSession();
        transaction = session.beginTransaction();
    }

    private void MasterOfEX(HibernateException HE) throws HibernateException {
        transaction.rollback();
        throw new HibernateException("Error en al acceder a datos en " + HE);
    }

    public void save(Participante_Bean object) throws HibernateException {
        try {
            StartOperation();
            session.save(object);
            transaction.commit();
        } catch (HibernateException HE) {
            MasterOfEX(HE);
        } finally {
            session.close();
        }
    }

    public void update(Participante_Bean object) throws HibernateException {
        try {
            StartOperation();
            session.update(object);
            transaction.commit();
        } catch (HibernateException HE) {
            MasterOfEX(HE);
            throw HE;
        } finally {
            session.close();
        }
    }

    public void delete(Participante_Bean object) throws HibernateException {
        try {
            StartOperation();
            session.delete(object);
            transaction.commit();
        } catch (HibernateException HE) {
            MasterOfEX(HE);
            throw HE;
        } finally {
            session.close();
        }
    }

    public Participante_Bean getObject(String id_object) throws HibernateException {
        Participante_Bean object = null;
        try {
            StartOperation();
            object = session.get(Participante_Bean.class, id_object);
        } finally {
            session.close();
        }
        return object;
    }

    public List<Participante_Bean> getlist() throws HibernateException {
        List<Participante_Bean> list = null;
        try {
            StartOperation();
            list = session.createQuery("FROM Participante_Bean ").list();
        } finally {
            session.close();
        }
        return list;
    }

}
