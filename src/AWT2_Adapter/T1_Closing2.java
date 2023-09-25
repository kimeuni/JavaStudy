package AWT2_Adapter;

import java.awt.Button;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

@SuppressWarnings("serial")
public class T1_Closing2 extends Frame {
	Button btnExit;	// 외부에 선언해두면 어디에서든지 사용 가능..
	
	public T1_Closing2() {
		// 디자인
		super("어뎁터 활용");
		setBounds(300, 250, 300, 350);
		
		btnExit = new Button("종 료");
		this.add(btnExit);	// 컨테이너에 올리기.. add 
		
		
		setVisible(true);
		
		//////////////////////////////////////////////////////////////
		// 동작
		
//		btnExit.addActionListener(this);
		// 2. 하지만, ActionListener처럼 인터페이스 안에 구현객체가 1개 밖에 없으면 ActionAdapter라는 클래스가 존재하지않는다.
		// 그래서 ActionListener는 ActionListener를 그대로 사용한다.
		btnExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		// 1. 인터페이스 안에 구현객체가 여러개 있으면 WindowAdapter가 존재한다.
		addWindowListener(new WindowAdapter() {	// 이런식으로 어댑터는 <익명객체>로 구현한다. (익명객체는 new로 생성해서 적는다.)
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	
	public static void main(String[] args) {
		new T1_Closing2();
	}
}
