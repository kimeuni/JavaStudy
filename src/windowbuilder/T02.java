package windowbuilder;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JCheckBox;

public class T02 extends JFrame {
	private ButtonGroup buttonGroup = new ButtonGroup();
	private JButton btnSubmit, btnReset;
	private JRadioButton rdbtnMale, rdbtnFemale;
	private JCheckBox chckbxhobby1, chckbxhobby2, chckbxhobby3, chckbxhobby4;

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					T02 frame = new T02();
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
	public T02() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 470);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pn1 = new JPanel();
		pn1.setBounds(12, 10, 660, 62);
		contentPane.add(pn1);
		pn1.setLayout(null);
		
		JLabel lblTitle = new JLabel("라디오 버튼 연습");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("굴림", Font.PLAIN, 28));
		lblTitle.setBounds(12, 10, 636, 42);
		pn1.add(lblTitle);
		
		JPanel pn2 = new JPanel();
		pn2.setBounds(12, 84, 660, 264);
		contentPane.add(pn2);
		pn2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("성 별");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 18));
		lblNewLabel.setBounds(46, 54, 96, 37);
		pn2.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("취 미");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(46, 117, 96, 37);
		pn2.add(lblNewLabel_1);
		
		rdbtnMale = new JRadioButton("남 자");
		rdbtnMale.setFont(new Font("굴림", Font.PLAIN, 18));
		rdbtnMale.setBounds(161, 52, 89, 41);
		buttonGroup.add(rdbtnMale);  // ==> rdbtnMale를 buttonGroup여기 그룹안에 넣겠다는 뜻
		pn2.add(rdbtnMale);
		
		rdbtnFemale = new JRadioButton("여 자");
		rdbtnFemale.setSelected(true);
		rdbtnFemale.setFont(new Font("굴림", Font.PLAIN, 18));
		rdbtnFemale.setBounds(301, 52, 89, 41);
		buttonGroup.add(rdbtnFemale);
		pn2.add(rdbtnFemale);
		
		JLabel lblMsg = new JLabel("");
		lblMsg.setHorizontalAlignment(SwingConstants.CENTER);
		lblMsg.setFont(new Font("굴림", Font.PLAIN, 18));
		lblMsg.setBackground(Color.CYAN);
		lblMsg.setBounds(121, 186, 418, 56);
		pn2.add(lblMsg);
		
		chckbxhobby1 = new JCheckBox("등 산");
		chckbxhobby1.setFont(new Font("굴림", Font.PLAIN, 18));
		chckbxhobby1.setBounds(153, 110, 89, 44);
		pn2.add(chckbxhobby1);
		
		chckbxhobby2 = new JCheckBox("낚 시");
		chckbxhobby2.setFont(new Font("굴림", Font.PLAIN, 18));
		chckbxhobby2.setBounds(275, 110, 89, 44);
		pn2.add(chckbxhobby2);
		
		chckbxhobby3 = new JCheckBox("수 영");
		chckbxhobby3.setFont(new Font("굴림", Font.PLAIN, 18));
		chckbxhobby3.setBounds(400, 110, 89, 44);
		pn2.add(chckbxhobby3);
		
		chckbxhobby4 = new JCheckBox("바 둑");
		chckbxhobby4.setFont(new Font("굴림", Font.PLAIN, 18));
		chckbxhobby4.setBounds(534, 110, 89, 44);
		pn2.add(chckbxhobby4);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 358, 660, 63);
		contentPane.add(panel);
		panel.setLayout(null);
		
		btnSubmit = new JButton("전송");
		btnSubmit.setFont(new Font("굴림", Font.PLAIN, 18));
		btnSubmit.setBounds(53, 10, 221, 43);
		panel.add(btnSubmit);
		
		btnReset = new JButton("종료");
		btnReset.setFont(new Font("굴림", Font.PLAIN, 18));
		btnReset.setBounds(390, 10, 221, 43);
		panel.add(btnReset);
		/*=================================================*/
		
		// 전송버튼
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String gender = "";
				if(rdbtnMale.isSelected()) gender = rdbtnMale.getText();	// isSelected ==> 선택됐니? 라고 물어보는거임. (true면 선택되어있다.)
				else if(rdbtnFemale.isSelected()) gender = rdbtnFemale.getText();
				
				String hobby = "";
				if(chckbxhobby1.isSelected()) hobby += chckbxhobby1.getText() + "/";
				if(chckbxhobby2.isSelected()) hobby += chckbxhobby2.getText() + "/";
				if(chckbxhobby3.isSelected()) hobby += chckbxhobby3.getText() + "/";
				if(chckbxhobby4.isSelected()) hobby += chckbxhobby4.getText() + "/";
				
				lblMsg.setText(gender);
				lblMsg.setText(hobby);
				JOptionPane.showMessageDialog(null, "성별 : " + gender + " 취미 : " + hobby);
			}
		});
		
		// 종료 버튼
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}
}
