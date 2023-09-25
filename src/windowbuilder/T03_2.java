package windowbuilder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;

public class T03_2 extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtAge;
	private JButton btnInput, btnUpdate, btnSearch, btnList,btnDelete, btnExit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					T03_2 frame = new T03_2();
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
	public T03_2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pn1 = new JPanel();
		pn1.setBackground(Color.LIGHT_GRAY);
		pn1.setBounds(12, 10, 760, 63);
		contentPane.add(pn1);
		pn1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("회 원 가 입");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 26));
		lblNewLabel.setBounds(12, 10, 736, 43);
		pn1.add(lblNewLabel);
		
		JPanel pn2 = new JPanel();
		pn2.setBackground(Color.WHITE);
		pn2.setBounds(12, 83, 760, 231);
		contentPane.add(pn2);
		pn2.setLayout(null);
		
		JLabel lblName = new JLabel("성 명");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setFont(new Font("굴림", Font.PLAIN, 18));
		lblName.setBounds(77, 42, 152, 45);
		pn2.add(lblName);
		
		JLabel lblAge = new JLabel("나 이");
		lblAge.setHorizontalAlignment(SwingConstants.CENTER);
		lblAge.setFont(new Font("굴림", Font.PLAIN, 18));
		lblAge.setBounds(77, 135, 152, 45);
		pn2.add(lblAge);
		
		txtName = new JTextField();
		txtName.setFont(new Font("굴림", Font.PLAIN, 18));
		txtName.setBounds(253, 42, 356, 45);
		pn2.add(txtName);
		txtName.setColumns(10);
		
		txtAge = new JTextField();
		txtAge.setFont(new Font("굴림", Font.PLAIN, 18));
		txtAge.setColumns(10);
		txtAge.setBounds(253, 135, 356, 45);
		pn2.add(txtAge);
		
		JPanel pn3 = new JPanel();
		pn3.setBackground(Color.LIGHT_GRAY);
		pn3.setBounds(12, 324, 760, 227);
		contentPane.add(pn3);
		pn3.setLayout(null);
		
		btnInput = new JButton("입 력");
		btnInput.setFont(new Font("굴림", Font.PLAIN, 16));
		btnInput.setBounds(68, 20, 265, 43);
		pn3.add(btnInput);
		
		btnUpdate = new JButton("수 정");
		btnUpdate.setFont(new Font("굴림", Font.PLAIN, 16));
		btnUpdate.setBounds(425, 20, 265, 43);
		pn3.add(btnUpdate);
		
		btnSearch = new JButton("개 별 조 회");
		btnSearch.setFont(new Font("굴림", Font.PLAIN, 16));
		btnSearch.setBounds(68, 84, 265, 43);
		pn3.add(btnSearch);
		
		btnList = new JButton("전 체 조 회");
		btnList.setFont(new Font("굴림", Font.PLAIN, 16));
		btnList.setBounds(425, 84, 265, 43);
		pn3.add(btnList);
		
		btnDelete = new JButton("삭 제");
		btnDelete.setFont(new Font("굴림", Font.PLAIN, 16));
		btnDelete.setBounds(68, 152, 265, 43);
		pn3.add(btnDelete);
		
		btnExit = new JButton("창 닫 기");
		btnExit.setFont(new Font("굴림", Font.PLAIN, 16));
		btnExit.setBounds(425, 152, 265, 43);
		pn3.add(btnExit);
		
		/*==================================================================*/
		/*
		// 입력 버튼
		btnInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "입력버튼을 클릭하셨습니다.");
				
			}
		});
		
		// 수정 버튼
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "수정버튼을 클릭하셨습니다.");
			}
		});
		
		// 개별조회 버튼
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "개별조회버튼을 클릭하셨습니다.");
			}
		});
		
		// 전체조회 버튼
		btnList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "전체조회버튼을 클릭하셨습니다.");
			}
		});
		
		// 삭제 버튼
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "삭제버튼을 클릭하셨습니다.");
			}
		});
		
		// 창닫기 버튼
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "작업을 종료합니다.");
				System.exit(0);
			}
		});
		*/
		
		// 좋은 방법은 아님! 1줄자리는 이렇게 적을 수 있지만, 애초에 1줄짜리를 적을 일이 별로 없기 때문이다.
		ActionListener listener = new ActionListener() { //익명객체는 필드명에 넣어서 사용한다.
			@Override
			public void actionPerformed(ActionEvent e) {
				if(btnInput.equals(e.getSource())) JOptionPane.showMessageDialog(null, "입력버튼을 클릭하셨습니다.");
				else if(btnUpdate.equals(e.getSource())) JOptionPane.showMessageDialog(null, "수정버튼을 클릭하셨습니다.");
				else if(btnSearch.equals(e.getSource())) JOptionPane.showMessageDialog(null, "개별조회버튼을 클릭하셨습니다.");
				else if(btnList.equals(e.getSource())) JOptionPane.showMessageDialog(null, "전체조회버튼을 클릭하셨습니다.");
				else if(btnDelete.equals(e.getSource())) JOptionPane.showMessageDialog(null, "삭제버튼을 클릭하셨습니다.");
				else if(btnExit.equals(e.getSource())) {
					JOptionPane.showMessageDialog(null, "수정버튼을 클릭하셨습니다.");
					System.exit(0);
				}
			}
		};	
		btnInput.addActionListener(listener);
		btnUpdate.addActionListener(listener);
		btnSearch.addActionListener(listener);
		btnList.addActionListener(listener);
		btnDelete.addActionListener(listener);
		btnExit.addActionListener(listener);
		
	}
}
