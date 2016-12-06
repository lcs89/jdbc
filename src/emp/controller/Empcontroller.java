package emp.controller;

import java.util.ArrayList;

import emp.model.dao.EmpDao;
import emp.model.dto.Employee;
import emp.view.EmpView;

public class Empcontroller { //뷰쪽에 뿌리는 역활을 해야됨 클래스가
	public Empcontroller(){}
	
	public void empSelectAll(){
		ArrayList<Employee> list = new EmpDao().selectAll();
		EmpView eview = new EmpView();
		
		if(list != null){ // 조회 성공
			eview.printAll(list);
		}else{ //조회실패
			eview.printError("직원 전체 조회서비스 실패!");
		}
	}
	
}
