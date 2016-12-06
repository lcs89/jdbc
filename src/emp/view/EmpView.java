package emp.view;

import java.util.ArrayList;
import java.util.Scanner;

import emp.controller.Empcontroller;
import emp.model.dto.Employee;

public class EmpView {

	public static void menu(){
		Scanner sc = new Scanner(System.in);
		Empcontroller econtroll = new Empcontroller();
		int no;
		
		do{
			System.out.println("\n\n*** ���� ���� ���α׷� ***\n");
			System.out.println("1. ���� ��ü ��ȸ");
			System.out.println("2. ������� ���� ��ȸ");
			System.out.println("3. ���� ���");
			System.out.println("4. ���� ���� ����");
			System.out.println("5. ���� ����");
			System.out.println("9. ���α׷� ������");
			System.out.println("��ȣ ���� : ");
			no = sc.nextInt();
			
			switch(no){
			case 1:		econtroll.empSelectAll(); break;
			case 2:
			case 3:
			case 4:
			case 5:
			case 9: System.out.println("���� ���� ���α׷��� �����մϴ�.");
					return;
			default : System.out.println("�߸� �Է� ... �ٽ� ����!!!");
			}
			
		}while(true);
	}
	
	//�������� ��� ���
	public void printAll(ArrayList<Employee> list){
		for(int i = 0; i < list.size(); i++){
			System.out.println((i+1)+ " : " + list.get(i)); 
		}
	}
	
	//���� �޼��� ��¿�
	public void printError(String message){
		System.out.println("\n���� : " + message);
	}
	public static void main(String[] args) {
		// �������� ���� ���α׷� ����
		menu();

	}

}