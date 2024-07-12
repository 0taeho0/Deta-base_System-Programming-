package kth_jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class JdbcMain {
	
	public static void main(String[] args) throws Exception {
		Connection con = DBConnect.getConnection();
		
		PreparedStatement pstmt;
		
		
		Scanner scan = new Scanner(System.in);
		boolean 진행 = true;
		System.out.println("SW212 PC방에 오실걸 환영합니다.");
		while(true) {
			System.out.printf("메뉴를 선택하세요.");
			System.out.printf("(1)Create (2)Read (3)Update (4)Delete (5)Exit >");
			int 선택 = scan.nextInt();
			
			switch (선택) {
			case 1:	//Create
				
				break;
			case 2: //Read
				
				break;
			case 3: //Update
				
				break;
			case 4: //Delete
				
				break;
			default: //Exit
				System.out.println("Bye~");
				진행 = false;
			}
		}		
	}

}
