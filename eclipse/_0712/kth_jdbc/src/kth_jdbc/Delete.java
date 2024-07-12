package kth_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Delete {

	public static void main(String[] args) throws Exception{
		Class.forName("oracle.jdbc.OracleDriver");
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		Connection con = DriverManager.getConnection(url, "sw212", "1234");
		
		String q = "select menu_name from pc_menu";
		PreparedStatement pstmt = con.prepareStatement(q);
		
		ResultSet rs = pstmt.executeQuery();
		
		
		Scanner scan = new Scanner(System.in);
		int cnt = 0;
		while(rs.next()) {
			cnt++;
			System.out.printf("%d.%-6s \t", cnt, rs.getString(1));
			if(cnt%5 == 0) System.out.println();
		}
		
		System.out.printf("\n삭제할 메뉴를 선택하세요. >");
		int choice = scan.nextInt();
		
		String 쿼리문2 = "delete from pc_menu" +
					" where menu_no = ? ";
		
		pstmt = con.prepareStatement(쿼리문2);
		pstmt.setInt(1, choice);
		
		int result = pstmt.executeUpdate();
		if(result == 1) {
			System.out.println(choice+" 번 메뉴가 정상적으로 삭제되었습니다.");
		}
	}

}
