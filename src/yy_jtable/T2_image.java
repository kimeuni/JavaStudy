package yy_jtable;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;

public class T2_image extends JFrame {

	private JPanel contentPane;
	private ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton rdImg1, rdImg2, rdImg3, rdImg4, rdImg5, rdImg6; 
	private JButton btnInfor;
	private JLabel lblInfor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					T2_image frame = new T2_image();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public T2_image() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pn1 = new JPanel();
		pn1.setBounds(12, 10, 760, 64);
		contentPane.add(pn1);
		pn1.setLayout(null);
		
		rdImg1 = new JRadioButton("그림1");
		rdImg1.setBounds(36, 6, 84, 52);
		buttonGroup.add(rdImg1);
		pn1.add(rdImg1);
		
		rdImg2 = new JRadioButton("그림2");
		rdImg2.setBounds(156, 6, 84, 52);
		buttonGroup.add(rdImg2);
		pn1.add(rdImg2);
		
		rdImg3 = new JRadioButton("그림3");
		rdImg3.setBounds(276, 6, 84, 52);
		buttonGroup.add(rdImg3);
		pn1.add(rdImg3);
		
		rdImg4 = new JRadioButton("그림4");
		rdImg4.setBounds(396, 6, 84, 52);
		buttonGroup.add(rdImg4);
		pn1.add(rdImg4);
		
		rdImg5 = new JRadioButton("그림5");
		rdImg5.setBounds(516, 6, 84, 52);
		buttonGroup.add(rdImg5);
		pn1.add(rdImg5);
		
		rdImg6 = new JRadioButton("그림6");
		rdImg6.setBounds(636, 6, 84, 52);
		buttonGroup.add(rdImg6);
		pn1.add(rdImg6);
		
		JPanel pn2 = new JPanel();
		pn2.setBounds(12, 84, 760, 393);
		contentPane.add(pn2);
		pn2.setLayout(null);
		
		JLabel lblImage = new JLabel("이곳에 선택한 그림이 출력됩니다.");
		lblImage.setHorizontalAlignment(SwingConstants.CENTER);
		lblImage.setBounds(12, 10, 736, 373);
		pn2.add(lblImage);
		
		JPanel pn3 = new JPanel();
		pn3.setBounds(12, 487, 760, 64);
		contentPane.add(pn3);
		pn3.setLayout(null);
		
		JButton btnExit = new JButton("종 료");
		btnExit.setFont(new Font("굴림", Font.PLAIN, 16));
		btnExit.setBounds(612, 10, 136, 44);
		pn3.add(btnExit);
		
		btnInfor = new JButton("그림정보 출력");
		btnInfor.setFont(new Font("굴림", Font.PLAIN, 16));
		btnInfor.setBounds(12, 10, 136, 44);
		pn3.add(btnInfor);
		
		lblInfor = new JLabel("");
		lblInfor.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfor.setBounds(160, 10, 437, 44);
		pn3.add(lblInfor);
		
		
		/*========================================================*/
		
		// '그림정보출력' 버튼 클릭시 수행처리
		btnInfor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String photo = "그림을 클릭하면 해당 그림파일의 정보가 출려됩니다";	//문자화 시킨 후
				if(lblImage.getIcon() != null) photo = lblImage.getIcon().toString();
				lblInfor.setText(photo);
			}
		});
		
		// 출려된 그림을 클릭할 때 수행처리
		lblImage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String photo = "그림을 클릭하면 해당 그림파일의 정보가 출려됩니다";	//문자화 시킨 후
				if(lblImage.getIcon() != null) photo = lblImage.getIcon().toString();
				lblInfor.setText(photo);
			}
		});
		
		// 그림 1 라디오버튼을 클릭하면 처리할 내용
		rdImg1.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == 1) lblImage.setIcon(new ImageIcon("./images/1.jpg"));	// 동작이 있을때는 1, 없을때는 0
			}
		});
		
		// 그림 2 라디오버튼을 클릭하면 처리할 내용
		rdImg2.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == 1) lblImage.setIcon(new ImageIcon("./images/2.jpg"));	// 동작이 있을때는 1, 없을때는 0
			}
		});
		
		// 그림 3 라디오버튼을 클릭하면 처리할 내용
		rdImg3.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == 1) lblImage.setIcon(new ImageIcon("./images/3.jpg"));	// 동작이 있을때는 1, 없을때는 0
			}
		});
		
		// 그림 4 라디오버튼을 클릭하면 처리할 내용
		rdImg4.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == 1) lblImage.setIcon(new ImageIcon("./images/4.jpg"));	// 동작이 있을때는 1, 없을때는 0
			}
		});
		
		// 그림 5 라디오버튼을 클릭하면 처리할 내용
		rdImg5.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == 1) lblImage.setIcon(new ImageIcon(getClass().getResource(("./images/main.jpg"))));	// 동작이 있을때는 1, 없을때는 0
			}
		});
		
		// 그림 6 라디오버튼을 클릭하면 처리할 내용
		rdImg6.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == 1) lblImage.setIcon(new ImageIcon(getClass().getResource(("./images/1.png"))));	// 동작이 있을때는 1, 없을때는 0
			}
		});
		
		
		// 종료 버튼 클릭시 수행
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
}
