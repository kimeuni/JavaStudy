package Swing3_Layout;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/*
 - CardLayout 사용법
 카드레이아웃 제어 메소드 : first(), last(), next(), show()
 first() : 첫번째 카드 보이기
 last()  : 마지막 카드 보이기
 next()  : 다음 카드 보이기
 show()  : 지정된 카드보이기 카드 보이기
*/
@SuppressWarnings("serial")
public class T04_cardLayout1_3 extends JFrame {
	private JButton btn;
	private JPanel pn1, pn2, pn3;
	
	public T04_cardLayout1_3() {
		super("CardLayout 연습");
		setSize(250,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		setLayout(new CardLayout());
		
		add(getPn1());
		add(getPn2());
		add(getPn3());
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
	}
	
//	int r = (int)(Math.random()*256); // 0~255 까지 랜덤숫자 발생
//	int g = (int)(Math.random()*256);
//	int b = (int)(Math.random()*256);
	
	
	private JPanel getPn1() {
		pn1 = new JPanel();
		pn1.setBackground(new Color(255,0,0));
		return pn1;
	}
	
	private JPanel getPn2() {
		pn2 = new JPanel();
		pn2.setBackground(new Color(0,255,0));
		return pn2;
	}
	
	private JPanel getPn3() {
		pn3 = new JPanel();
		pn3.setBackground(new Color(0,0,255));
		return pn3;
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				T04_cardLayout1_3 t04 = new T04_cardLayout1_3();
				t04.setVisible(true);
				
				// 반복 스레드 생성
				Thread thread = new Thread() {
					public void run() {	// Thread에서 기본적으로 제공하는 메소드 중 "run"이라는 메소드가 있다.
						while(true) {
							try {
								Thread.sleep(1000);	// 1000분의 1초   // 1초동안 멈춘다
							} catch (InterruptedException e) {}
							
							SwingUtilities.invokeLater(new Runnable() {
								@Override
								public void run() {
									CardLayout cardLayout = (CardLayout) t04.getContentPane().getLayout();
									cardLayout.next(t04.getContentPane());
								}
							});
						}
					}
				};
				thread.start();	// 스레드를 실행하기 위해서는 thread.start()가 필요하다.
			}
		});
	}
}
