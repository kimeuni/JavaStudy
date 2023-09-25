package Swing2_JFrame;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class T03_ImageIcon extends JFrame {
	
	public T03_ImageIcon() {
		setTitle("그림");
		setSize(600,500);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setIconImage(new ImageIcon(getClass().getResource("./images/1.png")).getImage());	// 띄우는 창.. 타이틀적힌 곳에 아이콘 이미지가 바뀐다.
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {	//스윙을 스레드 개념으로 관리... 이렇게하면 메모리를 더 효율적으로 관리할 수 있다...
			@Override
			public void run() {
				T03_ImageIcon t03 = new T03_ImageIcon();
				t03.setVisible(true);
			}
		});
	}
}
