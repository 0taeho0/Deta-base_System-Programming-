public class S21200_GetSetDb_Insert {

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in); 
      
      System.out.print("몇 명 성적처리를 하나요?(숫자입력)? ");
      int num = sc.nextInt();
      
      People stu[] = new People[num];
      
      for(int i = 0; i < stu.length; i++) {
         stu[i] = new People();   //매우중요!!!!!
         
         System.out.print("학번을 입력하세요 : ");
         stu[i].setHakbun(sc.nextInt());
         
         System.out.print("국어 점수를 입력하세요 : ");
         stu[i].setKor(sc.nextInt());
         
         System.out.print("영어 점수를 입력하세요 : ");
         stu[i].setEng(sc.nextInt());
         
         System.out.print("수학 점수를 입력하세요 : ");
         stu[i].setMath(sc.nextInt());
      }
      //석차 부여합시다. 총점 기준
      //총점이 같을 경우는 같은 등수, 차 등수는 같은 등수를 반영하여 적용한다.
      for(int i = 0; i < stu.length; i++) {
         int rank = 1;
         for(int j = 0; j < stu.length; j++) {
            if(stu[i].getSum() < stu[j].getSum()) rank++;
         }
         stu[i].setRank(rank);
      }
      
      //콘솔에 출력
      System.out.println("=================출력=================");
      System.out.printf("No    학번   국어 영어 수학 합계    평균  석차 \n");
      System.out.println("=====================================");
      for(int i = 0; i < stu.length; i++) {
         stu[i].cnt = i+1;
         stu[i].printScore();
      }
      
      //db 연결 후 입력된 자료 등록
      Connection conn = null;
      PreparedStatement pstmt = null;
      String sql;
      
      String url = "jdbc:oracle:thin:@localhost:1521:xe";
      String id = "system";
      String pw = "1234";
      
      try {
         Class.forName("oracle.jdbc.OracleDriver");
         System.out.println("클래스 로딩 성공");
         conn = DriverManager.getConnection(url, id, pw);
         System.out.println("DB접속 성공");
         
         for(int i = 0; i < stu.length; i++) {
            sql = "insert into sungil_jumsu_tbl values(?, ?, ?, ?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            
            pstmt.setInt(1, stu[i].getHakbun());
            pstmt.setInt(2, stu[i].getKor());
            pstmt.setInt(3, stu[i].getEng());
            pstmt.setInt(4, stu[i].getMath());
            pstmt.setInt(5, stu[i].getSum());
            pstmt.setDouble(6, stu[i].getAvg());
            pstmt.setInt(7, stu[i].getRank());
            
            pstmt.executeUpdate();
         }
         System.out.println("===================");
         System.out.println("DB 입력작업 성공 : " + stu.length);
         
         pstmt.close();
         conn.close();
         
      } catch(Exception e) {
         e.printStackTrace();
      }
   }
}
