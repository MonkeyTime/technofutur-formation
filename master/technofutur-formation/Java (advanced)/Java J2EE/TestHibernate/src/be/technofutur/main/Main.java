package be.technofutur.main;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import be.technofutur.domain.entities.Student;

@SuppressWarnings("unused")
public class Main {

	public static void main(String[] args) {
		
		/* Deprecated */
		//(new Configuration).configure().buildSessionFactory();
		
		Configuration cfg = new Configuration();
		cfg.configure();
		
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
		SessionFactory sf = cfg.buildSessionFactory(serviceRegistry);
		Session s = sf.openSession();
		//Transaction tx = s.beginTransaction();
		
		SQLQuery query = s.createSQLQuery("SELECT * FROM student");
		
		@SuppressWarnings("unchecked")
		List<Object[]> objects = query.list();
		
		for(Object[]  row : objects) {
			for(Object col : row) {
				System.out.print(col + " - ");
			}
			System.out.println();
		}
		
		s.close();
		
		/**/
		
		Session db = sf.openSession();
		
		Transaction sql = null;
		Integer id = null;
		
		try {
			
			sql = db.beginTransaction();
			
			Student student = new Student();
			student.setFirstName("Jacky");
			student.setLastName("Migol");
			
			db.persist(student);
			
			sql.commit();
			
		} catch(HibernateException e) {
			
			e.printStackTrace();
			
			if(sql != null && sql.isActive()) {
				
				sql.rollback();
			}
			
		} finally {
			
			db.close();
		}
		
		sf.close();	
	}

}
