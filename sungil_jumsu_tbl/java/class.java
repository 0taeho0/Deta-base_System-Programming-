class People {
	   private int hakbun;
	   private int kor;
	   private int eng;
	   private int math;
	   private int sum;
	   private double avg;
	   private int rank;
	   

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
	   public void setSum(int sum) {
	      this.sum = sum;
	   }

	   public double getAvg() {
	      return (double)getSum() / 3;
	   }
	   public void setAvg(double avg) {
	      this.avg = avg;
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
