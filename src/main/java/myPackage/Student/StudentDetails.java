package myPackage.Student;

import java.util.List;
import java.util.Scanner;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

@Entity
public class StudentDetails {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private int rollNo;
	private int passYear;
	private double mark;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public int getPassYear() {
		return passYear;
	}

	public void setPassYear(int passYear) {
		this.passYear = passYear;
	}

	public double getMark() {
		return mark;
	}

	public void setMark(double mark) {
		this.mark = mark;
	}
	public StudentDetails() {
		
	}

	public StudentDetails(String name, int rollNo, int passYear, double mark) {

//		this.id = id;
		this.name = name;
		this.rollNo = rollNo;
		this.passYear = passYear;
		this.mark = mark;
	}
//	Scanner sc = new Scanner(System.in);
//	Configuration cf = new Configuration().configure().addAnnotatedClass(StudentDetails.class);
//	SessionFactory sf = cf.buildSessionFactory();
//	Session session = sf.openSession();
//	
//	public void insertData() {
//		
//		System.out.println("Enter the Student's Name: ");
//		String name = sc.next();
//		
//		System.out.println("Enter the Student's Roll Number: ");
//		int rollNo = sc.nextInt();
//
//		System.out.println("Enter the Student's Passing Year: ");
//		int passYear = sc.nextInt();
//
//		System.out.println("Enter the Student Mark: ");
//		double mark = sc.nextDouble();
//
//		StudentDetails student1 = new StudentDetails(name, rollNo, passYear, mark);
//		Transaction tx = session.beginTransaction();
//		session.save(student1);
//
//		tx.commit();
//	}
//	
//	public void viewData() {
//		System.out.println("display :");
//		Query qr = session.createQuery("select o from StudentDetails o", StudentDetails.class);
////	Query q = session.createSQLQuery("Select * from Operations");
//		List<StudentDetails> s_details = (List<StudentDetails>) qr.getResultList();
//
//		System.out.println("ID\tName\t\tRoll No.\tPassing Year\tMark");
//		System.out.println("-----------------------------------------------------------------");
//		for (StudentDetails opt : s_details) {
//			System.out.println(opt.getId() + "\t" + opt.getName() + "\t\t" + opt.getRollNo() + "\t\t"
//					+ opt.getPassYear() + "\t\t" + opt.getMark());
//		}
//	}
//
//	
//	public void updateData() {
//		System.out.println("Enter the Student's ID for Updation: ");
//		int id = sc.nextInt();
//
//		Object object = session.get(StudentDetails.class, id);
//		StudentDetails operation = (StudentDetails) object;
//		if (object != null) {
//			// begin transaction
//			Transaction tx = session.beginTransaction();
//
//			// set the properties you want to update
//			System.out.println("which field do you want to change(name / rollno / passyear / mark): ");
//			String update_Field = sc.next().toLowerCase();
//
//			switch (update_Field) {
//			case "name": {
//				System.out.println("Enter the Student's New name: ");
//				String newname = sc.next();
//				operation.setName(newname);
//
//				session.update(operation);
//			}
//				break;
//
//			case "rollno": {
//				System.out.println("Enter the Student's New Roll Number: ");
//				int newroll = sc.nextInt();
//				operation.setRollNo(newroll);
//
//				session.update(operation);
//			}
//				break;
//
//			case "passyear": {
//				System.out.println("Enter the Student's New Passing Year: ");
//				int newpassyear = sc.nextInt();
//				operation.setPassYear(newpassyear);
//
//				session.update(operation);
//			}
//				break;
//			case "mark": {
//				System.out.println("Enter the Student's New Mark: ");
//				double newmark = sc.nextDouble();
//				operation.setMark(newmark);
//				;
//
//				session.update(operation);
//			}
//				break;
//
//			default:
//				System.out.println("Wrong choice for updation");
//			}
//			tx.commit();
//		} else {
//			System.out.println("This ID doesn't exist");
//		}
//	}
//	
//	public void deleteData() {
//		System.out.println("Enter the Student's ID for deletion: ");
//		int id = sc.nextInt();
//
//		Object object = session.get(StudentDetails.class, id);
//		StudentDetails operation = (StudentDetails) object;
//		if (operation != null) {
//			Transaction tx = session.beginTransaction();
//			session.delete(object);
//			tx.commit();
//		} else {
//			System.out.println("Id does not exist: ");
//		}
//	}
//	
//	
//	
//	public void trunkateData() {
//		System.out.println("Deleting all records :");
//		Query qr = session.createQuery("select o from StudentDetails o", StudentDetails.class);
//
//		List<StudentDetails> s_details = (List<StudentDetails>) qr.getResultList();
//
//		for (StudentDetails opt : s_details) {
//			Transaction tx = session.beginTransaction();
//			Object object = session.get(StudentDetails.class, opt.getId());
//			session.delete(object);
//			tx.commit();
//		}
//	}
}
