package swingEx1;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class T01_CardLayout1 extends JFrame{
	private JButton btn1, btn2, btn3, btn4;
	private JPanel pButton, pCenter;
	private JLabel lbl1, lbl2, lbl3, lbl4;
	
	public T01_CardLayout1() {
		super("cardLayout 응용");
		setSize(280,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		
		setLayout(new BorderLayout());
		
		lbl1 = new JLabel();
		lbl2 = new JLabel();
		lbl3 = new JLabel();
		lbl4 = new JLabel();
		
		lbl1.setIcon(new ImageIcon("./images/1.jpg"));
		lbl2.setIcon(new ImageIcon("./images/2.jpg"));
		lbl3.setIcon(new ImageIcon("./images/3.jpg"));
		lbl4.setIcon(new ImageIcon("./images/4.jpg"));
		
		pCenter = new JPanel();
		pCenter.add(lbl1);
		pCenter.add(lbl2);
		pCenter.add(lbl3);
		pCenter.add(lbl4);
		
		btn1 = new JButton("봄");
		btn2 = new JButton("여름");
		btn3 = new JButton("가을");
		btn4 = new JButton("겨울");
		
		pButton = new JPanel();
		pButton.add(btn1);
		pButton.add(btn2);
		pButton.add(btn3);
		pButton.add(btn4);
		
		add(pCenter, BorderLayout.CENTER);
		add(pButton, BorderLayout.SOUTH);
		
		/*------------------------------------------------------*/
		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lbl1.setVisible(true);
				lbl2.setVisible(false);
				lbl3.setVisible(false);
				lbl4.setVisible(false);
			}
		});
		
		btn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lbl1.setVisible(false);
				lbl2.setVisible(true);
				lbl3.setVisible(false);
				lbl4.setVisible(false);
			}
		});
		
		btn3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lbl1.setVisible(false);
				lbl2.setVisible(false);
				lbl3.setVisible(true);
				lbl4.setVisible(false);
			}
		});
		
		btn4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lbl1.setVisible(false);
				lbl2.setVisible(false);
				lbl3.setVisible(false);
				lbl4.setVisible(true);
			}
		});
		
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				T01_CardLayout1 c1 = new T01_CardLayout1();
				c1.setVisible(true);
			}
		});
	}
}
