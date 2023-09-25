package Swing3_Layout;

import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class t05_nullLayout1 extends JFrame {
	private JButton btnExit;
	
	public t05_nullLayout1() {
		super("절대위치(Null) 레이아웃");
		setSize(600,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		setLayout(null);
		
		add(getBtnExit());
		
		/*---------------------------------------------*/
		
	
	}
	
	private JButton getBtnExit() {
		btnExit = new JButton();
		btnExit.setText("종료");
		btnExit.setBounds(100, 80, 70, 50);
		return btnExit;
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				t05_nullLayout1 t05 = new t05_nullLayout1();
				t05.setVisible(true);
			}
		});
	}
}
