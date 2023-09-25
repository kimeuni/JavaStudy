package AWT1;

import java.awt.Frame;
import java.awt.Label;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class T3_Label extends Frame implements WindowListener {
	
	public T3_Label() {
		super("프레임 테스트");	
		setSize(400,300);
		
		Label lbl = new Label("회 원 가 입 폼");
		this.add(lbl);	// 방금 만든 lbl을 넣어주세요.
		
		
		setVisible(true);	
		/* --------------------------------- */
		
		addWindowListener(this);  // 감시자	// 밑이 있는 windowListner 메소드들 실행
	}
	
	public static void main(String[] args) {
		new T3_Label();
	}

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
}
