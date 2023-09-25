package Swing2_JFrame;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JWindow;
import javax.swing.SwingUtilities;

public class T04_Jwindow4 extends JWindow{	// JWindow도 컨테이너...
	JButton btnExit;
	
	public T04_Jwindow4() {
		setSize(600,350);
		
		btnExit = new JButton("종료");
		add(btnExit);
		
//		// Jwindow를 화면 중앙에 띄우기
//		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();	//그래픽디바이스의 정보를 가져옴... //싱글톤 개념으로 많이 사용한다.
//		Point centerPoint = ge.getCenterPoint();	//가운데 포인트를 가져옴..ge.getCenterPoint()
//		
//		int leftTopX = centerPoint.x - this.getWidth()/2;	//x축의 가운데 포인트 - 현재 너비 / 2
//		int leftTopY = centerPoint.y - this.getHeight()/2;	//y축의 가운데 포인트 - 현재 높이 / 2
//		setLocation(leftTopX,leftTopY);  // 현재 위치를 직접 잡아주는 명령어
		
		// 위에 적은 중앙 띄우기 계산한 것을 정리한 명령어... 밑에 명령어를 적으면 띄우는 창 위치가 가운데가 된다.
		setLocationRelativeTo(null);	// 화면 가운데 view(window) 배치하기
		
		
		btnExit.addMouseListener(new MouseAdapter() {
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
				T04_Jwindow4 t04 = new T04_Jwindow4();
				t04.setVisible(true);
			}
		});
	}
}