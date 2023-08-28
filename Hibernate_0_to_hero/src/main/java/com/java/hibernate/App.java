package com.java.hibernate;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import org.hibernate.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SecurityException, RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException
    {
        System.out.println( "project started ........................" );
         Configuration cfg= new Configuration();
         cfg.configure();
        SessionFactory factory=cfg.buildSessionFactory();
        System.out.println(factory);
        
        Employee em=new Employee();
        em.setFirstName("Rakhi");
        em.setId(3);
        em.setLastName("Saxena");
        em.setSalary(50000);
        
        
        Session session=factory.openSession();
        
         Transaction tx= session.beginTransaction();
         session.save(em);
         tx.commit();
         System.out.println(em);
         session.close();
       
         System.out.println("project ended..................");
    }
}
