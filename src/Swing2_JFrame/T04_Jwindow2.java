package Swing2_JFrame;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JWindow;
import javax.swing.SwingUtilities;

public class T04_Jwindow2 extends JWindow{	// JWindow도 컨테이너...
	JButton btnExit;
	
	public T04_Jwindow2() {
		setSize(600,350);
		
		btnExit = new JButton("종료");
		add(btnExit);
		
//		btnExit.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				System.exit(0);
//			}
//		});
		
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				System.exit(0);	//프로세스를 종료시켜버리기 때문에 이걸 사용하면 좋지 않다. (지금은 스레드를 1개만 사용해서 이상해보이지 않지만 여러개 사용시 다른 스레드들도 다 닫히기 때문에 좋지않음!)
//				setVisible(false);	// 잠깐 가린거... 이건 현재 스레드(스윙)자체를 닫은게 아니다..
				dispose();	// 해당 띄웠던 쓰레드만(스윙만) 날린다
			}
		});
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				T04_Jwindow2 t04 = new T04_Jwindow2();
				t04.setVisible(true);
			}
		});
	}
}