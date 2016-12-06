package emp.controller;

import java.util.ArrayList;

import emp.model.dao.EmpDao;
import emp.model.dto.Employee;
import emp.view.EmpView;

public class Empcontroller { //���ʿ� �Ѹ��� ��Ȱ�� �ؾߵ� Ŭ������
	public Empcontroller(){}
	
	public void empSelectAll(){
		ArrayList<Employee> list = new EmpDao().selectAll();
		EmpView eview = new EmpView();
		
		if(list != null){ // ��ȸ ����
			eview.printAll(list);
		}else{ //��ȸ����
			eview.printError("���� ��ü ��ȸ���� ����!");
		}
	}
	
}
