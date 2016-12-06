package emp.model.dao;

import java.sql.*;
import java.util.ArrayList;
import emp.model.dto.Employee;

//dao : data access object
//����Ͻ� ������ ����� Ŭ������ ����
//����Ͻ� �����̶�, �����ͺ��̽� ����, Ʈ������ ����, ������ ����, ���ó��
//���� ����
public class EmpDao {
	public EmpDao(){}
	
	//select all ó���ϴ� �޼ҵ�
	public ArrayList<Employee> selectAll(){//����ȯ �Ű�Ⱦ��� �ٷ� �ٲ��ֱ⶧���� ���ʸ���� (<>���ʸ�)
		ArrayList<Employee> list = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		
		try{

			//1. �ش� �����ͺ��̽��� �����ϴ� jdbc ����̹� Ŭ���� ���
			//Class.forName("Ŭ���� Ǯ name");
			Class.forName("oracle.jdbc.driver.OracleDriver"); //������ ojdbc jar ������ �߰����߰ų� ��Ÿ�ų� 
			System.out.println("����Ŭ ����̹� ��� ����!");
			
			//2. �����ͺ��̽��� ����
			//DriverManager.getConnection(url, user, pwd)
			//Connection ��ü�� ������, ���� �����ϸ�  null�� ���ϵ�
			//SQLException ó���ؾ� ��
			//Connection �� ����� ������ �ݵ�� �ݳ��ؾ� �� : close()
			conn = DriverManager.getConnection(
						"jdbc:oracle:thin:@127.0.0.1:1521:xe",
						"student", "student");
			System.out.println("conn : " + conn); // null �� �ƴϸ� ����
			
			//3. ������ �ۼ��ϰ� �����ϰ� �������
			String query = "select * from employee";
			
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			if(rset != null)
				list = new ArrayList<Employee>();
			//�� �྿ ������ ��ü�� �����ϰ�, ��ü�� ����Ʈ�� �߰���
			while(rset.next()){
				Employee emp = new Employee();
				emp.setEmpId(rset.getString("EMP_ID"));
				emp.setEmpName(rset.getString("EMP_NAME"));
				emp.setEmpNo(rset.getString("EMP_NO"));
				emp.setEmail(rset.getString("EMAIL"));
				emp.setPhone(rset.getString("PHONE"));
				emp.setHireDate(rset.getDate("HIRE_DATE"));
				emp.setJobId(rset.getString("JOB_ID"));
				emp.setSalary(rset.getInt("SALARY"));
				emp.setBonusPct(rset.getDouble("BONUS_PCT"));
				emp.setMarriage(rset.getString("MARRIAGE").charAt(0));
				emp.setMgrId(rset.getString("MGR_ID"));
				emp.setDeptId(rset.getString("DEPT_ID"));
				
				list.add(emp);
			}
			while(rset.next()){
				
			}
				
		}catch (ClassNotFoundException e){
			System.out.println("����Ŭ ����̹� Ŭ���� ã�� ����...");
			e.printStackTrace();
		}catch(SQLException e){
			System.out.println("�������... Statement ���� ����....�������� ����....");
			e.printStackTrace();
		}finally{
		try {
			rset.close();
			stmt.close();
			conn.close();
			} catch (SQLException e) {				
				e.printStackTrace();
			}
		}
		return list;
	}
	
	//select one ó���ϴ� �޼ҵ�
	public Employee selectOne(String empId){
		Employee emp = null;
		return emp;  
	}
	
	//insert �ϴ� �޼ҵ�
	public int insertEmp(Employee emp){ // ó���� ���� ������ �޴´�
		int result = 0;
		return result;
	}
	
	//update ó�� �޼ҵ�
	public int updateEmp(Employee emp){
		int result = 0;
		return result;
		
	}
	//delete ó�� �޼ҵ�
	public int deleteEmp(String empId){
		int result = 0;
		return result;
	}
}
