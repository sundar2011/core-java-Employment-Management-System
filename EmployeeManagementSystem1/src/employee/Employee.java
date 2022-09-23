package employee;
import java.io.Serializable;

public class Employee implements Serializable   {
	
	int id;
	String name;
	float salary;
	long contact_no;
	String email_id;
	public Employee(int id, String name, float salary, long contact_no, String email_id) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.contact_no = contact_no;
		this.email_id = email_id;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", contact_no=" + contact_no
				+ ", email_id=" + email_id + "]";
	}
	

}
