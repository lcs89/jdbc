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
		
		if(list != null){  //��ȸ����
			eview.printAll(list);
		}else{  //��ȸ����
			eview.printError("���� ��ü ��ȸ���� ����!");
		}
	}

	public void empSelectOne(String empId) {
		Employee emp = new EmpDao().selectOne(empId);
		
		if(emp != null)
			eview.printEmp(emp);
		else
			eview.printError(empId + " ��� ���� ��ȸ ����!");
	}
}
