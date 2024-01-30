package com.BikkadIT.HQLDynamicQueries;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class App 
{
    @SuppressWarnings("deprecation")
	public static void main( String[] args )
    {

      Configuration cfg = new Configuration();
      cfg.configure("config.xml");
      SessionFactory factory = cfg.buildSessionFactory();
      
      Student s = new Student();
      
      Session session = factory.openSession();
      
      String hql = "from Student where id = :x";
      Query query = session.createQuery(hql);
      query.setParameter("x", 2);
      List<Student> list = query.list();
      for(Student st:list) {
    	  System.out.println(st.getName());
    	  System.out.println(st.getAddress());
      }
      
      session.close();
      factory.close();
    }
}
