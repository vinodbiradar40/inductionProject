package com.tut.ProjectWithMaven;

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
        System.out.println( "Hello World!" );
        
        
        Configuration  configure=new Configuration().configure("hibernate.cfg.xml");
        
        SessionFactory session=configure.buildSessionFactory();
        
       Student st=new Student();
       st.setId(101);
       st.setName("Vinod");
       st.setCity("Pune");
        
       
       Session ses=session.openSession();
       
       Transaction tx=ses.beginTransaction();
       ses.save(st);
       
       tx.commit();
       
       ses.close();
        
    }
}
