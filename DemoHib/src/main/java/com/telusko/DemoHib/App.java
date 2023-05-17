package com.telusko.DemoHib;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    { 
        Alien a=new Alien();
        a.setAid(101);
        a.setName("Vinod");
        a.setColor("Green");
        
        Configuration con=new Configuration().configure().addAnnotatedClass(Alien.class);
        SessionFactory sf=con.buildSessionFactory();
        Session session=con.buildSessionFactory().openSession();
        
        Transaction tx=session.beginTransaction();
        
        session.save(a);
        
        tx.commit();
        
    }
}
