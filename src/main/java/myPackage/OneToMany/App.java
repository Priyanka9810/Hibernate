package myPackage.OneToMany;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import javax.persistence.Query;

//import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import myPackage.Student.StudentDetails;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		Configuration cf = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Department_Info.class)
				.addAnnotatedClass(Cource_Info.class);
		SessionFactory sf = cf.buildSessionFactory();
		Session session = sf.openSession();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("How many Departments you want to enter: ");
		int s_no = sc.nextInt();
		for(int i=0; i<s_no ; i++) {
//			System.out.println("Enter ID for Student "+(i+1)+":");
//			int id= sc.nextInt();
			System.out.println("Enter Name for Department "+(i+1)+":");
			String s_name= sc.next();
			System.out.println("Enter the No. of Faculty for the Department "+(i+1)+":");
			int f_no= sc.nextInt();		
			Department_Info dept1 = new Department_Info(s_name,f_no);
			System.out.println("Enter the no. of Subjects does the Department "+(i+1)+" take:");
			int c_no = sc.nextInt();
			
			for(int j=0; j<c_no ; j++) {
				System.out.println("Enter the Id of Subject "+(j+1)+" for Department "+(i+1)+":");
				String c_id= sc.next();				
				System.out.println("Enter the Name of Subject "+(j+1)+" for Department "+(i+1)+":");
				String c_name= sc.next();
				System.out.println("Enter the Credit for the Subject "+(j+1)+":");
				int credit= sc.nextInt();				
				List<Cource_Info> c1 = Arrays.asList(new Cource_Info(c_id,s_name,c_name,credit));
				dept1.setCource_name(c1);
				session.save(dept1);			
				Transaction tx = session.beginTransaction();
				tx.commit();
			}
			
		}
		
		//fetching data from department table
		System.out.println("Display the Department Table :");
		Query qr = session.createQuery("select o from Department_Info o",Department_Info.class);
		List<Department_Info> d_details = (List<Department_Info>) qr.getResultList();
		System.out.println("Department ID\tDepartment Name\t\tNo. of Faculty");
		System.out.println("-----------------------------------------------------------------");
		for (Department_Info dinfo : d_details) {
			System.out.println(dinfo.getId()+"\t\t"+dinfo.getName()+"\t\t"+dinfo.getFacultyNo());
		}
		
		//fetching data from student table
		System.out.println("Display the Cource Table :");
		Query qr1 = session.createQuery("select o from Cource_info o",Cource_Info.class);
		List<Cource_Info> c_details = (List<Cource_Info>) qr1.getResultList();
		System.out.println("Cource ID\tCource Name\tDepartment Name\tCredits");
		System.out.println("-----------------------------------------------------------------");
		for (Cource_Info cinfo : c_details) {
			System.out.println(cinfo.getCource_Id()+"\t"+cinfo.getCource_name()+"\t"+cinfo.getDepartment()+"\t\t"+cinfo.getCredit());
		}
		
		//fetching data from mapping table
//		System.out.println("Display the Student Table :");
//		Query qr1 = session.createQuery("select o from Department_Info_Cource_info o",Cource_Info.class);
//		List<Cource_Info> c_details = (List<Cource_Info>) qr1.getResultList();
//		System.out.println("Cource ID\tCource Name\tDepartment Name\tCredits");
//		System.out.println("-----------------------------------------------------------------");
//		for (Cource_Info cinfo : c_details) {
//			System.out.println(cinfo.getCource_Id()+"\t"+cinfo.getCource_name()+"\t"+cinfo.getDepartment()+"\t\t"+cinfo.getCredit());
//		}
		
//		Student_Info student1 = new Student_Info(1,"priya",101,"MCA");
//		Student_Info student2 = new Student_Info(2,"sashi",102,"MBA");
//		
//		List<Cource_Info> c1 = Arrays.asList(new Cource_Info("MCA001","MCA","OS",5),
//				new Cource_Info("MCA002","MCA","DBMS",5),
//						new Cource_Info("MCA003","MCA","JAVA",6),new Cource_Info("MCA004","MCA","DS",5));
//		
//		List<Cource_Info> c2 = Arrays.asList(new Cource_Info("MBA001","MBA","English",5),
//				new Cource_Info("MBA002","MBA","Ecology",5),
//						new Cource_Info("MBA003","MBA","BD",6));
//		
//		student1.setDeparment_name(c1);
//		student1.setDeparment_name(c2);
//
//		
//		session.save(student2);
//		session.save(student1);
		
		
//		session.close();
		sf.close();

	}
}
