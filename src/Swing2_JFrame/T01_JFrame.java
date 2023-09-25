package Swing2_JFrame;

import javax.swing.JFrame;

@SuppressWarnings("serial")	// 이거 넣어도되고 안 넣어고 ㄱㅊ 그냥 T01_JFrame클래스 이름에 노란줄 안뜨게 하고 싶으면 넣기
public class T01_JFrame extends JFrame {
	
	public T01_JFrame() {
		setTitle("스윙연습2");
		setBounds(300,250,300,150);
	}
	
	public static void main(String[] args) {
		T01_JFrame t1 = new T01_JFrame();
		t1.setVisible(true);
	}
}
