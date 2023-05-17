package com.control;


import org.hibernate.cfg.Configuration;

public class HibernateMain 
{
public static void main(String args[]) 
{
	Configuration configuration=new Configuration().configure();
	configuration.addAnnotatedClass(com.to.Player.class);
	ServiceRegistryBuilder builder=new ServiceRegistryBuilder
}

}
