package Swing3_Layout;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayer;
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
public class T04_cardLayout2 extends JFrame {
	private JButton btn1, btn2;
	private JPanel pnb1, pnb2, pnb3, pn1, pn2, pn3;
	private JLabel lbl1;
	
	public T04_cardLayout2() {
		super("CardLayout 연습");
		setSize(250,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		
		setLayout(new BorderLayout());
//		BorderLayout blayer = new BorderLayout();
		
		pnb1 = new JPanel();
		pnb1.setBackground(Color.CYAN);
		pnb2 = new JPanel();
		pnb2.setBackground(Color.MAGENTA);
		
		CardLayout card = new CardLayout();
//		pnb1.setLayout(card);
		
		
		btn1 = new JButton("버튼1");
		btn2 = new JButton("버튼2");
		
		pnb2.add(btn1);
		pnb2.add(btn2);
		
		add(pnb1, BorderLayout.CENTER);
		add(pnb2, BorderLayout.SOUTH);
		
	}
	

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				T04_cardLayout2 t04 = new T04_cardLayout2();
				t04.setVisible(true);
			}
		});
	}
}
