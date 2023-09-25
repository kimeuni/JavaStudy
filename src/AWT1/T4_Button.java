package AWT1;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class T4_Button extends Frame implements WindowListener, ActionListener {
	
	public T4_Button() {
		super("프레임 테스트");	
//		setSize(400,300);
		setBounds(300, 300, 400, 300);
		
		// 이름표(Label)	: 레이블 컴포넌트
		Label lbl = new Label("회 원 가 입 폼");
		this.add(lbl);	// 방금 만든 lbl을 넣어주세요.	//this 생략 가능
		
		// 버튼 컴포넌트
		Button btnExit = new Button("종료");
		add(btnExit);
		
		setVisible(true);	
		/* --------------------------------- */
		btnExit.addActionListener(this);	// btnExit를 감시한다.. // 클릭하는 <액션>을 감시하는 감시자(리스너)
		
		addWindowListener(this);  // 감시자	// 밑이 있는 windowListner 메소드들 실행
	}
	
	public static void main(String[] args) {
		new T4_Button();
	}

	// WindowListener 메소드
	//  WindowListener inplements 받은 메소드들 필요 없는 것들은 닫기.
	@Override
	public void windowOpened(WindowEvent e) {}

	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	@Override
	public void windowClosed(WindowEvent e) {}

	@Override
	public void windowIconified(WindowEvent e) {}

	@Override
	public void windowDeiconified(WindowEvent e) {}

	@Override
	public void windowActivated(WindowEvent e) {}

	@Override
	public void windowDeactivated(WindowEvent e) {}

	//ActionListener 메소드
	@Override
	public void actionPerformed(ActionEvent e) {
		System.exit(0);
		
	}
}
