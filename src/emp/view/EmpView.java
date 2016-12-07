package emp.view;

import java.util.ArrayList;
import java.util.Scanner;

import emp.controller.Empcontroller;
import emp.model.dto.Employee;

public class EmpView {

	private static Scanner sc = new Scanner(System.in);
	public static void menu(){

		Empcontroller econtroll = new Empcontroller();
		int no;
		
		do{
			System.out.println("\n\n*** 직원 관리 프로그램 ***\n");
			System.out.println("1. 직원 전체 조회");
			System.out.println("2. 사번으로 직원 조회");
			System.out.println("3. 직원 등록");
			System.out.println("4. 직원 정보 변경");
			System.out.println("5. 직원 삭제");
			System.out.println("9. 프로그램 끝내기");
			System.out.println("번호 선택 : ");
			no = sc.nextInt();
			
			switch(no){
			case 1:		econtroll.empSelectAll(); break;
			case 2:		econtroll.empSelectOne(inputEmpId()); break;
			case 3:
			case 4:
			case 5:
			case 9: System.out.println("직원 관리 프로그램을 종료합니다.");
					return;
			default : System.out.println("잘못 입력 ... 다시 실행!!!");
			}
			
		}while(true);
	}
	//사번을 키보드로 입력받아, 사번 리턴하는 메소드
	public static String inputEmpId(){
		System.out.println("\n조회할 사번 : ");
		return sc.next();
	}
	
	
	//직원정보 모두 출력
	public void printAll(ArrayList<Employee> list){
		for(int i = 0; i < list.size(); i++){
			System.out.println((i+1)+ " : " + list.get(i)); 
		}
	}
	
	//에러 메세지 출력용
	public void printError(String message){
		System.out.println("\n에러 : " + message);
	}
	public static void main(String[] args) {
		// 사우너정보 관리 프로그램 구동
		menu();

	}
	public void printEmp(Employee emp) {
		System.out.println("\n조회된 직원 정보는 아래와 같습니다....");
		System.out.println("\n"  + emp);
		// TODO Auto-generated method stub
		
	}

}
