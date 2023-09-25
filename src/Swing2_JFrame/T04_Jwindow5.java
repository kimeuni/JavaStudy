package Swing2_JFrame;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JWindow;
import javax.swing.SwingUtilities;

public class T04_Jwindow5 extends JWindow{	// JWindow도 컨테이너...
	JLabel lblImg;
	
	public T04_Jwindow5() {
		setSize(600,350);
		
//		lblImg = new JLabel("안녕하세요.");
//		add(lblImg);	//컨텐트 패널에 들어간다.
		
		// 그림 띄우기
		lblImg = new JLabel();
		lblImg.setIcon(new ImageIcon(getClass().getResource("./images/1.png")));
		add(lblImg);
		
		setLocationRelativeTo(null);	// 화면 가운데 view(window) 배치하기
		
		addMouseListener(new MouseAdapter() {	// 마우스포인트 감시.. 화면 어디든지 클릭을하면 닫는다.
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				T04_Jwindow5 t05 = new T04_Jwindow5();
				t05.setVisible(true);
			}
		});
	}
}