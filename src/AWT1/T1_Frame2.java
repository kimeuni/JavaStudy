package AWT1;

import java.awt.Frame;

// GUI 프로그램?
//@SupperessWarnings("serial")
public class T1_Frame2 extends Frame {
	
	public T1_Frame2() {
		super("프레임 테스트");	//frame.setTitle("AWT 연습"); 이거랑 같다.
		setSize(400,300);
		setVisible(true);	
	}
	
	public static void main(String[] args) {
//		Frame frame = new Frame();	//프레임 객체 생성
//		
//		// 설정할 때 무조건 Set을 사용한다.
//		frame.setTitle("AWT 연습");   // 윈도우창의 제목(?)이 만들어진다.
//		frame.setSize(400,300);		// (폭, 높이) 지정한 단위는 항상 픽셀(px)단위이다.
//		
//		frame.setVisible(true);
		
		new T1_Frame2();	// 생성하면서 뷰를 디자인
		
	}
}
