package Swing2_JFrame;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

// 스레드
public class T02_InvokeLater extends JFrame {
		
	public T02_InvokeLater() {
		setTitle("스윙 이벤트 큐");
		setSize(300,200);
		
		System.out.println("2222222222222222222");
		
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	
	public static void main(String[] args) {
		System.out.println("1111111111111");
		
		T02_InvokeLater t02 = new T02_InvokeLater();
		t02.setVisible(true);
		System.out.println(Thread.currentThread().getName()); // 현재 돌아가는 스레드
		System.out.println("3333333333333333333");
	}
}
