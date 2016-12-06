package emp.model.dao;

import java.sql.*;
import java.util.ArrayList;
import emp.model.dto.Employee;

//dao : data access object
//비즈니스 로직을 담당할 클래스를 말함
//비즈니스 로직이란, 데이터베이스 연결, 트렌잯ㄴ 관리, 쿼리문 실행, 결과처리
//등을 말함
public class EmpDao {
	public EmpDao(){}
	
	//select all 처리하는 메소드
	public ArrayList<Employee> selectAll(){//형변환 신경안쓰로 바로 바꿔주기때문에 제너릭사용 (<>제너릭)
		ArrayList<Employee> list = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		
		try{

			//1. 해당 데이터베이스가 제공하는 jdbc 드라이버 클래스 등록
			//Class.forName("클래스 풀 name");
			Class.forName("oracle.jdbc.driver.OracleDriver"); //에러시 ojdbc jar 파일을 추가안했거나 오타거나 
			System.out.println("오라클 드라이버 등록 성공!");
			
			//2. 데이터베이스와 연결
			//DriverManager.getConnection(url, user, pwd)
			//Connection 객체를 리턴함, 연결 실패하면  null이 리턴됨
			//SQLException 처리해야 함
			//Connection 은 사용이 끝나면 반드시 반납해야 함 : close()
			conn = DriverManager.getConnection(
						"jdbc:oracle:thin:@127.0.0.1:1521:xe",
						"student", "student");
			System.out.println("conn : " + conn); // null 이 아니면 성공
			
			//3. 쿼리문 작성하고 실행하고 결과받음
			String query = "select * from employee";
			
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			if(rset != null)
				list = new ArrayList<Employee>();
			//한 행씩 꺼내서 객체에 저장하고, 객체를 리스트에 추가함
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
			System.out.println("오라클 드라이버 클래스 찾기 실패...");
			e.printStackTrace();
		}catch(SQLException e){
			System.out.println("연결실패... Statement 생성 실패....쿼리실행 실패....");
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
	
	//select one 처리하는 메소드
	public Employee selectOne(String empId){
		Employee emp = null;
		return emp;  
	}
	
	//insert 하는 메소드
	public int insertEmp(Employee emp){ // 처리한 행의 갯수를 받는다
		int result = 0;
		return result;
	}
	
	//update 처리 메소드
	public int updateEmp(Employee emp){
		int result = 0;
		return result;
		
	}
	//delete 처리 메소드
	public int deleteEmp(String empId){
		int result = 0;
		return result;
	}
}
