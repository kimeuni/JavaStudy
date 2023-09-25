package Swing3_Layout;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
public class T04_cardLayout1_2 extends JFrame {
	private JButton btn;
	private JPanel pn1, pn2, pn3;
	
	public T04_cardLayout1_2() {
		super("CardLayout 연습");
		setSize(250,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		
		CardLayout card = new CardLayout();
		
//		setLayout(new CardLayout());
		setLayout(card);
		
//		pn1 = new JPanel();
//		pn1.setBackground(Color.RED);
		
		
		pn2 = new JPanel();
		pn2.setBackground(Color.GREEN);
		pn2.setName("green");
		
//		add(pn1);
		add("red",getPn1());
		add(pn2);
		add("blue",getPn3());
		
		/*---------------------------------------------------*/
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				card.next(getContentPane()); // == > 컨텍트팬에 있는 것을 넘겨라
			}
		});
		
	}
	
	private JPanel getPn3() {
		pn3 = new JPanel();
		pn3.setBackground(Color.BLUE);
		return pn3;
	}

	private JPanel getPn1() {
		pn1 = new JPanel();
		int r = (int)(Math.random()*256); // 0~255 까지 랜덤숫자 발생
		int g = (int)(Math.random()*256);
		int b = (int)(Math.random()*256);
//		pn1.setBackground(Color.RED);
		pn1.setBackground(new Color(r,g,b));	// Coler(r,g,b)
		return pn1;
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				T04_cardLayout1_2 t04 = new T04_cardLayout1_2();
				t04.setVisible(true);
			}
		});
	}
}
