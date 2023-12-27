package com.excelr;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.excelr.entity.Contract_Employee;
import com.excelr.entity.Employee;
import com.excelr.entity.Regular_Employee;
import com.excelr.entity.e3.Contract_Employee3;
import com.excelr.entity.e3.Employee3;
import com.excelr.entity.e3.Regular_Employee3;

public class TablePerConcrete {
	public static void main(String[] args) {

		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

		SessionFactory factory = meta.getSessionFactoryBuilder().build();
		Session session = factory.openSession();

		Transaction t = session.beginTransaction();
		
		Employee e1 = new Employee();
		e1.setName("Lakshmikant Deshpande");

		Regular_Employee e2 = new Regular_Employee();
		e2.setName("Vivek Kumar");
		e2.setSalary(50000);
		e2.setBonus(5);

		Contract_Employee e3 = new Contract_Employee();
		e3.setName("Arjun Kumar");
		e3.setPay_per_hour(1000);
		e3.setContract_duration("10 hours");

		session.persist(e1);
		session.persist(e2);
		session.persist(e3);

		t.commit();
		session.close();
		System.out.println("success");

//		Employee3 e1 = new Employee3();
//		e1.setName("Gaurav Chawla");
//
//		Regular_Employee3 e2 = new Regular_Employee3();
//		e2.setName("Vivek Kumar");
//		e2.setSalary(50000);
//		e2.setBonus(5);
//
//		Contract_Employee3 e3 = new Contract_Employee3();
//		e3.setName("Arjun Kumar");
//		e3.setPay_per_hour(1000);
//		e3.setContract_duration("15 hours");
//
//		session.persist(e1);
//		session.persist(e2);
//		session.persist(e3);
//
//		t.commit();
//		session.close();
//		System.out.println("success");
	}
}
