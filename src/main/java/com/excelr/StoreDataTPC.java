package com.excelr;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.excelr.entity.e4.Contract_Employee4;
import com.excelr.entity.e4.Employee4;
import com.excelr.entity.e4.Regular_Employee4;

public class StoreDataTPC {

	public static void main(String args[]) {
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

		SessionFactory factory = meta.getSessionFactoryBuilder().build();
		Session session = factory.openSession();

		Transaction t = session.beginTransaction();

		Employee4 e1 = new Employee4();
		e1.setName("Raj Chawla");

		Regular_Employee4 e2 = new Regular_Employee4();
		e2.setName("Vivek B");
		e2.setSalary(50000);
		e2.setBonus(5);

		Contract_Employee4 e3 = new Contract_Employee4();
		e3.setName("Ajay Kumar");
		e3.setPay_per_hour(1000);
		e3.setContract_duration("15 hours");

		session.persist(e1);
		session.persist(e2);
		session.persist(e3);

		t.commit();
		session.close();
		System.out.println("success");
	}
}