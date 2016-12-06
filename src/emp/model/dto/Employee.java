package emp.model.dto;

import java.io.Serializable;
import java.sql.Date;

//dto(data transfer object) == do(domain object) == entity
//== vo(value object) == bean
//1. 반드시 캡슐화되어야 함 : 모든 필드는 private 
//2. 반드시 직렬화되어야 함 
//3. 기본생성자와 매개변수 있는 생성자 있어야 함
//4. 모든 필드에 대한 setters and getters 작성되어야 한다
public class Employee implements Serializable{
	//Field
	private String empId;
	private String empName;
	private String empNo;
	private String email;
	private String phone;
	private Date hireDate;
	private String jobId;
	private int salary;
	private double bonusPct;
	private char marriage;
	private String mgrId;
	private String deptId;
	
	//Constructor
		public Employee(){}
	
	public Employee(String empId, String empName, String empNo, String email, String phone, Date hireDate, String jobId,
			int salary, double bonusPct, char marriage, String mgrId, String deptId) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empNo = empNo;
		this.email = email;
		this.phone = phone;
		this.hireDate = hireDate;
		this.jobId = jobId;
		this.salary = salary;
		this.bonusPct = bonusPct;
		this.marriage = marriage;
		this.mgrId = mgrId;
		this.deptId = deptId;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpNo() {
		return empNo;
	}
	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Date getHireDate() {
		return hireDate;
	}
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}
	public String getJobId() {
		return jobId;
	}
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public double getBonusPct() {
		return bonusPct;
	}
	public void setBonusPct(double bonusPct) {
		this.bonusPct = bonusPct;
	}
	public char getMarriage() {
		return marriage;
	}
	public void setMarriage(char marriage) {
		this.marriage = marriage;
	}
	public String getMgrId() {
		return mgrId;
	}
	public void setMgrId(String mgrId) {
		this.mgrId = mgrId;
	}
	public String getDeptId() {
		return deptId;
	}
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	@Override
	public String toString(){
		return this.empId + ", " + this.empName + ", " + this. empNo 
				+ ", " + this.email + ", " + this.salary + ", " 
				+ this.bonusPct + ", " 	+ this.hireDate + ", " 
				+ this.jobId + ", " + this.deptId 
				+ ", " + this.mgrId + ", " + this.marriage;
	}
	
}
