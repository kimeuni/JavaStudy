package swingEx1;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class T03_TabbedPane extends JFrame{
	private JTabbedPane tabbedPane;
	private JPanel pnTab1, pnTab2;
	
	public T03_TabbedPane() {
		setTitle("TabbedPane연습");
		setSize(600,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);

		add(getTabbedPane(), BorderLayout.CENTER);
	}
	
	private JTabbedPane getTabbedPane() {
		tabbedPane = new JTabbedPane();
		tabbedPane.setTabPlacement(JTabbedPane.TOP);
		tabbedPane.addTab("탭1", getPnTab1());
		tabbedPane.addTab("탭2", getPnTab2());
		return tabbedPane;
	}
	
	// 첫번째 탭 설정... (pnTab1)
	private JPanel getPnTab1() {
		pnTab1 = new JPanel();
		JLabel lblImg = new JLabel();	//이 블럭에서만 사용할거면 위에 올리지 않고 하는게 메모리차원에서 더 좋다.
		lblImg.setIcon(new ImageIcon(getClass().getResource("./images/1.jpg")));
		pnTab1.add(lblImg);
		return pnTab1;
	}
	
	// 두번째 탭 설정... (pnTab2)
	private JPanel getPnTab2() {
		pnTab2 = new JPanel();
		JLabel lblImg = new JLabel();	//이 블럭에서만 사용할거면 위에 올리지 않고 하는게 메모리차원에서 더 좋다.
		lblImg.setIcon(new ImageIcon(getClass().getResource("./images/2.jpg")));
		pnTab2.add(lblImg);
		return pnTab2;
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				T03_TabbedPane t03 = new T03_TabbedPane();
				t03.setVisible(true);
			}
		});
	}
}
