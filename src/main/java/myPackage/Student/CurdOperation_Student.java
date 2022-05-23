package myPackage.Student;

import java.util.List;
import java.util.Scanner;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class CurdOperation_Student {

	Scanner sc = new Scanner(System.in);
	Configuration cf = new Configuration().configure().addAnnotatedClass(StudentDetails.class);
	SessionFactory sf = cf.buildSessionFactory();
	Session session = sf.openSession();

	public void insertData() {

		System.out.println("Enter the Student's Name: ");
		String name = sc.next();

		System.out.println("Enter the Student's Roll Number: ");
		int rollNo = sc.nextInt();

		System.out.println("Enter the Student's Passing Year: ");
		int passYear = sc.nextInt();

		System.out.println("Enter the Student Mark: ");
		double mark = sc.nextDouble();

		StudentDetails student1 = new StudentDetails(name, rollNo, passYear, mark);
		Transaction tx = session.beginTransaction();
		session.save(student1);

		tx.commit();
	}

	public void viewData() {
		System.out.println("display :");
		Query qr = session.createQuery("select o from StudentDetails o", StudentDetails.class);
//	Query q = session.createSQLQuery("Select * from Operations");
		List<StudentDetails> s_details = (List<StudentDetails>) qr.getResultList();

		System.out.println("ID\tName\t\tRoll No.\tPassing Year\tMark");
		System.out.println("-----------------------------------------------------------------");
		for (StudentDetails opt : s_details) {
			
			System.out.println(opt.getId() + "\t" + opt.getName() + "\t\t" + opt.getRollNo() + "\t\t"
					+ opt.getPassYear() + "\t\t" + opt.getMark());
			
		}
	}

	public void updateData() {
		System.out.println("Enter the Student's ID for Updation: ");
		int id = sc.nextInt();

		Object object = session.get(StudentDetails.class, id);
		StudentDetails operation = (StudentDetails) object;
		if (object != null) {
			// begin transaction
			Transaction tx = session.beginTransaction();

			// set the properties you want to update
			System.out.println("which field do you want to change(name / rollno / passyear / mark): ");
			String update_Field = sc.next().toLowerCase();

			switch (update_Field) {
			case "name": {
				System.out.println("Enter the Student's New name: ");
				String newname = sc.next();
				operation.setName(newname);

				session.update(operation);
			}
				break;

			case "rollno": {
				System.out.println("Enter the Student's New Roll Number: ");
				int newroll = sc.nextInt();
				operation.setRollNo(newroll);

				session.update(operation);
			}
				break;

			case "passyear": {
				System.out.println("Enter the Student's New Passing Year: ");
				int newpassyear = sc.nextInt();
				operation.setPassYear(newpassyear);

				session.update(operation);
			}
				break;
			case "mark": {
				System.out.println("Enter the Student's New Mark: ");
				double newmark = sc.nextDouble();
				operation.setMark(newmark);
				;

				session.update(operation);
			}
				break;

			default:
				System.out.println("Wrong choice for updation");
			}
			tx.commit();
		} else {
			System.out.println("This ID doesn't exist");
		}
	}

	public void deleteData() {
		System.out.println("Enter the Student's ID for deletion: ");
		int id = sc.nextInt();

		Object object = session.get(StudentDetails.class, id);
		StudentDetails operation = (StudentDetails) object;
		if (operation != null) {
			Transaction tx = session.beginTransaction();
			session.delete(object);
			tx.commit();
		} else {
			System.out.println("Id does not exist: ");
		}
	}

	public void trunkateData() {
		System.out.println("Deleting all records :");
		Query qr = session.createQuery("select o from StudentDetails o", StudentDetails.class);

		List<StudentDetails> s_details = (List<StudentDetails>) qr.getResultList();

		for (StudentDetails opt : s_details) {
			Transaction tx = session.beginTransaction();
			Object object = session.get(StudentDetails.class, opt.getId());
			session.delete(object);
			tx.commit();
		}
	}

	
	
	public static void main(String[] args) {
		char c = 'y';
		do {
			Configuration cf = new Configuration().configure().addAnnotatedClass(StudentDetails.class);
			SessionFactory sf = cf.buildSessionFactory();
			Session session = sf.openSession();
			Scanner sc = new Scanner(System.in);
			CurdOperation_Student c1 = new CurdOperation_Student();
			System.out.println("Enter the choice you want: ");
			System.out.println(
					"1.Insert a record\n2.View All records\n3.Update a Record\n4.Delete a record\n5.Truncate Records");

			int choice = sc.nextInt();

			switch (choice) {

			case 1: {
               //Insert a element
				c1.insertData();
			}
				break;

			case 2: {
               //view all records
				c1.viewData();

			}
				break;

			case 3: {
               //updating a recording selecting a ID
				c1.updateData();
			}
				break;

			case 4: {

				System.out.println("ALL records are:");
				c1.viewData();

				// deleting a single record
				c1.deleteData();
			}
				break;

			case 5: {	
				// Truncate All records
				c1.trunkateData();
				System.out.println("After Trunkate Table: ");
				c1.viewData();

			}
				break;
			default:
				System.out.println("Wrong Choice");

			}

			session.close();
			sf.close();

			System.out.println("If you want to countinue press y");

			c = sc.next().charAt(0);
			c = Character.toLowerCase(c);
		} while (c == 'y');
		System.out.println("Thank You");
	}

}
