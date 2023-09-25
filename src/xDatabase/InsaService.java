package xDatabase;

import java.util.Calendar;

public class InsaService {
	InsaVO vo = null;
	
	// 오늘 날짜 구하기
	public InsaVO getDefaultDate() {
		vo = new InsaVO();
		
		Calendar cal = Calendar.getInstance();	//캘린더(칼랜더)는 싱글톤 객체이기 때문에 getInstance()로 불러와야 한다.
		vo.setStrYY(cal.get(Calendar.YEAR) + "");	// Calender.YEAR,MONTH,DATE등은 int로 넘어오기 때문에 +""를 해서 문자로 바꿔준다.
		vo.setStrMM(cal.get(Calendar.MONTH) + 1 + "");	//MONTH는 8월(이전 월)로 넘어오기 때문에 +1을 한다.
		vo.setStrDD(cal.get(Calendar.DATE) + "");
		
		
		
		return vo;
	}
	
}
