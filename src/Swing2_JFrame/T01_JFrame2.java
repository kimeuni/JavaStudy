package Swing2_JFrame;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")	// 이거 넣어도되고 안 넣어고 ㄱㅊ 그냥 T01_JFrame클래스 이름에 노란줄 안뜨게 하고 싶으면 넣기
public class T01_JFrame2 extends JFrame {
	JButton btnExit;
	
	public T01_JFrame2() {
		setTitle("스윙연습2");
		setBounds(300,250,300,150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	// 윈도우 창 종료하기 //JFrame.EXIT_ON_CLOSE==> JFrame을 탈출한다. //이 객체가 현재 열려있는 윈도우 창을 닫아주는 역할을 해줌.
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		btnExit = new JButton("Exit");
		add(btnExit);
		
		btnExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(ABORT);
			}
		});
	}
	
	public static void main(String[] args) {
		T01_JFrame2 t1 = new T01_JFrame2();
		t1.setVisible(true);
	}
}
