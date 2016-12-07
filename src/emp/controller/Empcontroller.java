package emp.controller;

import java.util.ArrayList;

import emp.model.dao.EmpDao;
import emp.model.dto.Employee;
import emp.view.EmpView;

public class Empcontroller {
	private EmpView eview = new EmpView();
	
	public Empcontroller(){}
	
	public void empSelectAll(){
		ArrayList<Employee> list = new EmpDao().selectAll();		
		
		if(list != null){  //조회성공
			eview.printAll(list);
		}else{  //조회실패
			eview.printError("직원 전체 조회서비스 실패!");
		}
	}

	public void empSelectOne(String empId) {
		Employee emp = new EmpDao().selectOne(empId);
		
		if(emp != null)
			eview.printEmp(emp);
		else
			eview.printError(empId + " 사번 직원 조회 실패!");
	}
}
