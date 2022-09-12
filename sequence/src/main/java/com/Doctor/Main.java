package com.Doctor;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;


public class Main {

	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
	     Session s = sf.openSession();
	     Transaction tx = s.beginTransaction();
	     System.out.println("ConnectionSuccessfull!");
	     
	     DoctorSG d1 = new DoctorSG();
	     d1.setName("Barath");
	     s.save(d1);
	     DoctorSG d11 = new DoctorSG();
	     d11.setName("Asritha");
	     s.save(d11);
	     
	   //Using Query
	  /*   System.out.println("With Query- Using Like - Doctor name starts with 'B' ");
	     Query q1 = s.createQuery("from DoctorSG D where D.name like 'B%' ");
	     List<DoctorSG> l = q1.list();
	     for(DoctorSG d1 : l)
	     {
	    	 System.out.println("Name:"+d1.getName());
	     }
	     //CriteriaQuery
	     //Display
	     Criteria criteria = s.createCriteria(DoctorSG.class);
	     List<DoctorSG> list = criteria.list();
	     for(DoctorSG d : list)
	     {
	    	 System.out.println("Id : "+d.getId()+"\tName:"+d.getName());
	     }
	     //Like 
	     System.out.println("Using Like - Doctor name starts with 'A' ");
	     list = s.createCriteria(DoctorSG.class).add(Restrictions.like("name", "A%")).list();
	     for(DoctorSG d : list)
	     {
	    	 System.out.println("Name:"+d.getName());
	     }
	     //OrderBy
	     long count = (Long)s.createCriteria(DoctorSG.class)
	    		 .setProjection(Projections.rowCount())
	    		 .add(Restrictions.like("name", "A%")).uniqueResult();
	    		
	     System.out.println("Number of Doctors starts with 'A' name : "+count);
	     
	     long count1 = (Long)s.createCriteria(DoctorSG.class)
	    		 .setProjection(Projections.rowCount())
	    		 .uniqueResult();
	       
	     System.out.println("Number of Doctors : "+count1);*/
	     
	  /*   //AGGREGATE FUNCTION
	     //Count
	     Query q1 = s.createQuery("select count(id) from DoctorSG");
	     System.out.println("Count : "+q1.list().get(0));
	   
	     //Min
	     Query q11 = s.createQuery("select min(id) from DoctorSG");
	     System.out.println("Min : "+q11.list().get(0));
	     
	     //Max
	     Query q2 = s.createQuery("select max(id) from DoctorSG");
	     System.out.println("Max : "+q2.list().get(0));
	     
	     //Sum
	     Query q3 = s.createQuery("select sum(id) from DoctorSG");
	     System.out.println("Sum : "+q3.list().get(0));
	     
	     //Avg
	     Query q4 = s.createQuery("select avg(id) from DoctorSG");
	     System.out.println("Avg : "+q4.list().get(0)); */
	     
	     //Update
	   /*  Query q1 = s.createQuery("update DoctorSG d set d.name =:n where id=:id ");
	     q1.setParameter("n","Uday");
	     q1.setParameter("id",102);*/
	     
	     //Delete
	     Query q1 = s.createQuery("delete DoctorSG d where id=:id ");
	     q1.setParameter("id", 103);   
	     int status = q1.executeUpdate();
	     System.out.println(status);
	     
	     tx.commit();
	     s.close();
	     sf.close();   
	}

}
