package a_000_java_after_getset_db;

import java.sql.*;
import java.util.*;


class PeopleInquiry {
   private int hakbun;
   private int kor;
   private int eng;
   private int math;
   private int rank;
   //private int sum;
   //private double avg;
	   

	   public int cnt;

	   public int getHakbun() {
	      return hakbun;
	   }
	   public void setHakbun(int hakbun) {
	      this.hakbun = hakbun;
	   }

	   public int getKor() {
	      return kor;
	   }
	   public void setKor(int kor) {
	      this.kor = kor;
	   }

	   public int getEng() {
	      return eng;
	   }
	   public void setEng(int eng) {
	      this.eng = eng;
	   }

	   public int getMath() {
	      return math;
	   }
	   public void setMath(int math) {
	      this.math = math;
	   }

	   public int getSum() {
	      return getKor() + getEng() + getMath();
	   }
	   
	   public int getRank() {
	      return rank;
	   }
	   public void setRank(int rank) {
	      this.rank = rank;
	   }
	   
	   void printScore() {
	      System.out.printf("%3d %6d %3d %3d %3d %3d %3.1f %3d \n", 
                  cnt, hakbun, kor, eng, math, getSum(), getAvg(), rank);
   }
}

public class S21200_GetSetDB_inquiry {
	
	public static void main(String[] args) {
		//db 연결 후 입력된 자료 등록
	      Connection conn = null;
	      PreparedStatement pstmt = null;
	      String sql;
	      int num_count = 0; // 등록된 데이터 베이스 자료 건수
	     
	      String url = "jdbc:oracle:thin:@localhost:1521:xe";
	      String id = "system";
	      String pw = "1234";
	      
	      try {
	         Class.forName("oracle.jdbc.OracleDriver");
	         System.out.println("클래스 로딩 성공");
	         conn = DriverManager.getConnection(url, id, pw);
	         System.out.println("DB접속 성공");
	         
	         sql = "select count(*) from sungil_jumsu_tbl";
	         pstmt = conn.prepareStatement(sql);
	         ResultSet rs = pstmt.executeQuery();
	         rs.next();
	         num_count = rs.getInt(1);
	         
	      } catch(SQLException e) {
	    	  System.out.println("SQL을 확인합니다");
	         e.printStackTrace();
	      }catch(Exception e) {
		     e.printStackTrace();
		  }
	      System.out.println("등록된 자료 : "+num_count+"건");
	      System.out.println("=================출력=================");
	      System.out.printf("No    학번   국어 영어 수학 합계    평균  석차 \n");
	      System.out.println("=====================================");
	      
	      try {
	    	  sql = "select * from sungil_jumsu_tbl";
	    	  pstmt = conn.prepareStatement(sql);
	    	  ResultSet rs = pstmt.executeQuery();
	    	  PeopleInquiry p = new PeopleInquiry();
	    	  
	    	  num_count = 0;
	    	  while(rs.next()) {
	    		  p.cnt = num_count + 1;
	    		  p.setHakbun(rs.getInt("Hakbun"));
	    		  p.setHakbun(rs.getInt("kor"));
	    		  p.setHakbun(rs.getInt("eng"));
	    		  p.setHakbun(rs.getInt("math"));
	    		  p.setHakbun(rs.getInt("sum"));
	    		  p.setHakbun(rs.getInt("rank"));
	    		  
	    		  
	    	  }
	    	  
	    	  
	    	  
		} catch (Exception e) {
			e.printStackTrace();
		}
	      
	}
}
