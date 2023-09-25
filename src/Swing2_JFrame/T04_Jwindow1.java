package Swing2_JFrame;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JWindow;
import javax.swing.SwingUtilities;

public class T04_Jwindow1 extends JWindow implements MouseListener{	// JWindow도 컨테이너...
	JButton btnExit;
	
	public T04_Jwindow1() {
		setSize(600,350);
		
		btnExit = new JButton("종료");
		add(btnExit);
		
//		btnExit.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				System.exit(0);
//			}
//		});
		
		btnExit.addMouseListener(this);
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				T04_Jwindow1 t04 = new T04_Jwindow1();
				t04.setVisible(true);
			}
		});
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.exit(0);
	}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}
}
