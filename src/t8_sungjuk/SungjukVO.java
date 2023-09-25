package t8_sungjuk;

public class SungjukVO {
	private int idx;		//데이터베이스 테이블에 설정했던 필드가 들어와 있다.
	private String name;
	private int kor;
	private int eng;
	private int mat;
	
	private int tot;		// 1. 데이터베이스에 설정한 필드외에 추가로 사용할것 같은 것이 있다면 추가로 변수 선언해두면 좋다.
	private double avg;		// 2. 프로그램 쓰다보면 더 필요한 변수들을 그때그때 선언해줘도 괜찮고.. 아니면 미리 필요하다고 생각하는 것을 적어준다...
	private char grade;		// 3. 이 추가로 들어간 변수들은 테이블과 구별하기 위해 한줄 띄우고 사용한다.
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public int getMat() {
		return mat;
	}
	public void setMat(int mat) {
		this.mat = mat;
	}
	
	public int getTot() {
		return tot;
	}
	public void setTot(int tot) {
		this.tot = tot;
	}
	public double getAvg() {
		return avg;
	}
	public void setAvg(double avg) {
		this.avg = avg;
	}
	public char getGrade() {
		return grade;
	}
	public void setGrade(char grade) {
		this.grade = grade;
	}
	@Override
	public String toString() {
		return "SungjukVO [idx=" + idx + ", name=" + name + ", kor=" + kor + ", eng=" + eng + ", mat=" + mat + ", tot="
				+ tot + ", avg=" + avg + ", grade=" + grade + "]";
	}
}
