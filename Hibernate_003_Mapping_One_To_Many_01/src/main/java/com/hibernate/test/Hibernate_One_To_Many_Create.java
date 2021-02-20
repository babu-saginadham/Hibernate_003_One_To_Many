package com.hibernate.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.entity.Address;
import com.entity.Marks;
import com.entity.Student;

public class Hibernate_One_To_Many_Create {
 
    public static void main(String[] args) {
    	
    	SessionFactory sessionFactoryObj = null;
    	Session session = null;
    	
        try {
        	
        	// Creating Configuration Instance & Passing Hibernate Configuration File
            Configuration configObj = new Configuration();
            configObj.configure("hibernate.cfg.xml");
            
            configObj.addAnnotatedClass(com.entity.Student.class);
            configObj.addAnnotatedClass(com.entity.Address.class);
            configObj.addAnnotatedClass(com.entity.Marks.class);
     
            // Since Hibernate Version 4.x, ServiceRegistry Is Being Used
            ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder().applySettings(configObj.getProperties()).build(); 
     
            // Creating Hibernate SessionFactory Instance
            sessionFactoryObj = configObj.buildSessionFactory(serviceRegistryObj);
            
        	session = sessionFactoryObj.openSession();
            session.beginTransaction();
 
            Student stud = new Student();
            stud.setName("Babu");
            stud.setUser_email("babu@gmail.com");
            
            Address address = new Address();
            address.setDno("10-1");
            address.setStreet("street");
            stud.setAddress(address);
            
            List<Marks> marks = new ArrayList<Marks>();
            Marks m1 = new Marks();
            m1.setSub_name("Math");
            m1.setMark(89);
			marks.add(m1);
			
			Marks m2 = new Marks();
            m2.setSub_name("Physics");
            m2.setMark(90);
            marks.add(m2);
            
			stud.setMarks(marks);
            
            session.save(stud);
            
            // Committing The Transactions To The Database
            session.getTransaction().commit();
        } catch(Exception sqlException) {
        	System.out.println("Exception :" + sqlException);
        	
            if(null != session && null != session.getTransaction()) {
                System.out.println("\n.......Transaction Is Being Rolled Back.......");
                session.getTransaction().rollback();
            }
            sqlException.printStackTrace();
        } finally {
            if(session != null) {
                session.close();
            }
        }
    }
    
}
