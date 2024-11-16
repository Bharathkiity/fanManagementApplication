  package com.edubridge.fanapp.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.edubridge.fanapp.model.Fan;
import com.edubridge.fanapp.utils.HibernateUtils;

public class FanDao implements FanDaoI {

    @Override
    public void addFan(Fan fan) {
        Transaction tx = null;

        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.persist(fan);
            tx.commit();
            System.out.println("New fan added!");
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public List<Fan> getAllFans() {
        List<Fan> fans = new ArrayList<>();
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            String hql = "from Fan";
            Query<Fan> query = session.createQuery(hql, Fan.class);
            fans = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fans;
    }

    @Override
    public Fan getFanById(Integer id) {
        Fan fan = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            fan = session.get(Fan.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fan;
    }

    @Override
    public void updateFan(Fan fan) {
        Transaction tx = null;

        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.merge(fan);
            tx.commit();
            System.out.println("Fan updated!");
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void deleteFan(Integer id) {
        Transaction tx = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            
            Fan fan = session.get(Fan.class, id);
            if (fan != null) {
                session.remove(fan);
                tx.commit();
                System.out.println("Fan deleted!");
            } else {
                System.out.println("No fan found!");
            }
        } catch (Exception e) {
           tx.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void deleteAllFans() {
        Transaction tx = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            String hql = "delete from Fan";
            Query<?> query = session.createQuery(hql);
            query.executeUpdate();
            tx.commit();
            System.out.println("All fans deleted!");
        } catch (Exception e) {
             tx.rollback();
            e.printStackTrace();
        }
    }
}
