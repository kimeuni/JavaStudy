package AWT2_Adapter;

import java.awt.Button;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

@SuppressWarnings("serial")
public class T1_Closing1 extends Frame implements WindowListener, ActionListener{
	Button btnExit;	// 외부에 선언해두면 어디에서든지 사용 가능..
	
	public T1_Closing1() {
		// 디자인
		super("어뎁터 활용");
		setBounds(300, 250, 300, 350);
		
		btnExit = new Button("종 료");
		this.add(btnExit);	// 컨테이너에 올리기.. add 
		
		
		setVisible(true);
		
		//////////////////////////////////////////////////////////////
		// 동작
		
		btnExit.addActionListener(this);
		
		addWindowListener(this);
	}
	
	public static void main(String[] args) {
		new T1_Closing1();
	}

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

	@Override
	public void actionPerformed(ActionEvent e) {
		System.exit(0);
	}
}
