package Swing2_JFrame;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

// 스레드
public class T02_InvokeLater2 extends JFrame {
		
	public T02_InvokeLater2() {
		setTitle("스윙 이벤트 큐");
		setSize(300,200);
		
		System.out.println("2222222222222222222");
		
		
//		addWindowListener(new WindowAdapter() {
//			@Override
//			public void windowClosing(WindowEvent e) {
//				System.exit(0);
//			}
//		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 현재 떠 있는 JFrame을 닫는다.
	}
	
	public static void main(String[] args) {
		System.out.println("1111111111111");
		
		SwingUtilities.invokeLater(new Runnable() {	//스윙을 따로 관리.. //이렇게하면 이제 스레드는 따로 관리한다. //익명객체로 사용	// 스레드를 관리하는 클래스(?)
			@Override
			public void run() {
				T02_InvokeLater2 t02 = new T02_InvokeLater2();
				t02.setVisible(true);
				System.out.println(Thread.currentThread().getName()); // 현재 돌아가는 스레드
			}
		});	
		
		System.out.println("3333333333333333333");
		System.out.println(Thread.currentThread().getName()); // 현재 돌아가는 스레드
	}
}
