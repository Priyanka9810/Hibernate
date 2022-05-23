package myPackage.OneToMany;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "c_info")
@Entity
public class Cource_Info {
	@Id
//	@ManyToOne
    @JoinColumn(name="id")
	@Column(name = "Cource_Id")
	private String id;
	private String department;
	private String cource_name;
	private int credit;

	public String getCource_Id() {
		return id;
	}

	public void setCource_Id(String id) {
		this.id = id;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}


	public String getCource_name() {
		return cource_name;
	}

	public void setCource_name(String cource_name) {
		this.cource_name = cource_name;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public Cource_Info() {

	}

	public Cource_Info(String id, String department, String cource_name, int credit) {

		this.id = id;
		this.department = department;
		this.cource_name = cource_name;
		this.credit = credit;
	}

	

}
