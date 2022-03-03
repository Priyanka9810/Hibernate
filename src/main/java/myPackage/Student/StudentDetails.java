package myPackage.Student;

import javax.annotation.processing.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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

}
