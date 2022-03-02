package myPackage.OneToMany;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Table(name="d_info")
@Entity
public class Department_Info {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="Department_Id")
	private int id;
	private String name;
	private int facultyNo;
	@OneToMany(cascade = CascadeType.ALL,mappedBy="d_info")	
	private List<Cource_Info> cource_name;
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
	public int getFacultyNo() {
		return facultyNo;
	}
	public void setFacultyNo(int facultyNo) {
		this.facultyNo = facultyNo;
	}
	public List<Cource_Info> getCource_name() {
		return cource_name;
	}
	public void setCource_name(List<Cource_Info> cource_name) {
		this.cource_name = cource_name;
	}
	
	public Department_Info() {
		
	}
	public Department_Info( String name, int facultyNo) {

		this.name = name;
		this.facultyNo = facultyNo;
	}
	
	
}

