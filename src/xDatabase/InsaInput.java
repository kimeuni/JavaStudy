package xDatabase;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.regex.Pattern;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class InsaInput extends JFrame {

	private ButtonGroup buttonGroup = new ButtonGroup();
	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtAge;
	private JRadioButton rdMale, rdFemale;
	private JButton btnInput, btnReset, btnClose;
	
	InsaDAO dao = new InsaDAO();
	InsaVO vo = null;
	
	int res = 0;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					InsaInput frame = new InsaInput();
//					//frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
		new InsaInput();	// 위에처럼 하면 static으로 적혀있어서 생성하자마자 뷰를 보여달라는 명령어가 맨 위 메소드로 올려버리기 때문에 안된다.. ?? (말 정리 다시 해야 할 듯)
	}

	/**
	 * Create the frame.
	 */
	public InsaInput() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setVisible(true);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pn1 = new JPanel();
		pn1.setBounds(12, 10, 760, 80);
		contentPane.add(pn1);
		pn1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("회 원 가 입 폼");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 24));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(12, 10, 736, 60);
		pn1.add(lblNewLabel);
		
		JPanel pn2 = new JPanel();
		pn2.setBounds(12, 100, 760, 361);
		contentPane.add(pn2);
		pn2.setLayout(null);
		
		JLabel lblName = new JLabel("성 명");
		lblName.setFont(new Font("굴림", Font.PLAIN, 22));
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setBounds(102, 35, 174, 53);
		pn2.add(lblName);
		
		JLabel lblAge = new JLabel("나 이");
		lblAge.setHorizontalAlignment(SwingConstants.CENTER);
		lblAge.setFont(new Font("굴림", Font.PLAIN, 22));
		lblAge.setBounds(102, 119, 174, 53);
		pn2.add(lblAge);
		
		JLabel lblGender = new JLabel("성 별");
		lblGender.setHorizontalAlignment(SwingConstants.CENTER);
		lblGender.setFont(new Font("굴림", Font.PLAIN, 22));
		lblGender.setBounds(102, 200, 174, 53);
		pn2.add(lblGender);
		
		JLabel lblIpsail = new JLabel("입 사 일");
		lblIpsail.setHorizontalAlignment(SwingConstants.CENTER);
		lblIpsail.setFont(new Font("굴림", Font.PLAIN, 22));
		lblIpsail.setBounds(102, 281, 174, 53);
		pn2.add(lblIpsail);
		
		txtName = new JTextField();
		txtName.setFont(new Font("굴림", Font.PLAIN, 22));
		txtName.setBounds(306, 35, 346, 53);
		pn2.add(txtName);
		txtName.setColumns(10);
		
		txtAge = new JTextField();
		txtAge.setFont(new Font("굴림", Font.PLAIN, 22));
		txtAge.setColumns(10);
		txtAge.setBounds(306, 119, 346, 53);
		pn2.add(txtAge);
		
		rdMale = new JRadioButton("남 자");
		rdMale.setSelected(true);
		rdMale.setFont(new Font("굴림", Font.PLAIN, 22));
		rdMale.setBounds(306, 200, 147, 53);
		buttonGroup.add(rdMale);
		pn2.add(rdMale);
		
		rdFemale = new JRadioButton("여 자");
		rdFemale.setFont(new Font("굴림", Font.PLAIN, 22));
		rdFemale.setBounds(505, 200, 147, 53);
		buttonGroup.add(rdFemale);
		pn2.add(rdFemale);
		
		String[] yy = new String[24];
		String[] mm = new String[12];	//12월
		String[] dd = new String[31];	//최대일	(데이터베이스 함수를 사용하여 월마다 마지막일을 찾을 수 있음... 활용해보기..)
		
		int imsi;
		for(int i=0; i<yy.length; i++) {
			imsi =i+2000;	//2000년부터 시작
			yy[i] = imsi + ""; // yy가 String배열이기 때문에 + ""를 사용하여 문자로 바꿔서 yy에 넣어준다.
		}
		
		for(int i=0; i<mm.length; i++) {
			mm[i] = (i+1) + ""; // imsi를 사용하지 않고 바로 넘길 수도 있다.
		}
		
		for(int i=0; i<dd.length; i++) {
			imsi =i+2000;	
			dd[i] = (i+1) + ""; 
		}
		
		
		
		JComboBox cbYY = new JComboBox(yy);	// 배열 변수를 넣어준다. ==> 그냥 적으면 넣을 년도를 다 적어야 해서 길게 되겠지만, 바로 위에서 한 것 처럼 변수를 만들고 for문을 돌려 원하는 값을 넣어준 후 그 변수를 생성할 때 넣어준다.(new JComboBox(yy))
		cbYY.setFont(new Font("굴림", Font.PLAIN, 20));
		cbYY.setBounds(306, 281, 81, 53);
		pn2.add(cbYY);
		
		JComboBox cbMM = new JComboBox(mm);	// 배열 변수를 넣어준다.
		cbMM.setFont(new Font("굴림", Font.PLAIN, 20));
		cbMM.setBounds(441, 281, 81, 53);
		pn2.add(cbMM);
		
		JComboBox cbDD = new JComboBox(dd);	// 배열 변수를 넣어준다.
		cbDD.setFont(new Font("굴림", Font.PLAIN, 20));
		cbDD.setBounds(571, 281, 81, 53);
		pn2.add(cbDD);
		
		JLabel lblYY = new JLabel("년");
		lblYY.setFont(new Font("굴림", Font.PLAIN, 20));
		lblYY.setBounds(399, 281, 33, 53);
		pn2.add(lblYY);
		
		JLabel lblMM = new JLabel("월");
		lblMM.setFont(new Font("굴림", Font.PLAIN, 20));
		lblMM.setBounds(534, 281, 33, 53);
		pn2.add(lblMM);
		
		JLabel lblDD = new JLabel("일");
		lblDD.setFont(new Font("굴림", Font.PLAIN, 20));
		lblDD.setBounds(664, 281, 33, 53);
		pn2.add(lblDD);
		
		JPanel pn3 = new JPanel();
		pn3.setBounds(12, 471, 760, 80);
		contentPane.add(pn3);
		pn3.setLayout(null);
		
		btnInput = new JButton("가 입 하 기");
		btnInput.setFont(new Font("굴림", Font.PLAIN, 20));
		btnInput.setBounds(70, 10, 159, 60);
		pn3.add(btnInput);
		
		btnReset = new JButton("다 시 입 력");
		btnReset.setFont(new Font("굴림", Font.PLAIN, 20));
		btnReset.setBounds(299, 10, 159, 60);
		pn3.add(btnReset);
		
		btnClose = new JButton("창 닫 기");
		btnClose.setFont(new Font("굴림", Font.PLAIN, 20));
		btnClose.setBounds(528, 10, 159, 60);
		pn3.add(btnClose);
		
		/*----------------------------------------------------------------*/
		
		// 회원가입 버튼
		btnInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = txtName.getText();  // ==> name변수에 txtName에 적은 글을 getText로 읽어와 저장한다.
				String age = txtAge.getText();
				String gender;	// gender는 선택된거를 가져와야하기 때문에 선언만 해놓는다.
				String ipsail = cbYY.getSelectedItem() + "-" + cbMM.getSelectedItem() + "-" + cbDD.getSelectedItem(); //yyyy-mm-dd (데이터베이스는 date타입이기 때문에 yyyy-mm--dd 맞춰서 넣어주어야 한다.)
				
				if(name.trim().equals("")) {
					JOptionPane.showMessageDialog(null, "성명을 입력하세요.");
					txtName.requestFocus();
				}
				else if(age.trim().equals("")) {
					JOptionPane.showMessageDialog(null, "나이를 입력하세요.");
					txtAge.requestFocus();
				}
				else {
					if(!Pattern.matches("^[0-9]*$", age)) {
						JOptionPane.showMessageDialog(null, "나이는 숫자만 입력하세요.");
						txtAge.requestFocus();
					}
					else {
						if(rdMale.isSelected()) gender = "남자"; // ==> rdMale.isSelected()의 뜻은 rdMale(남자)의 라디오버튼이 체크(isSelected)된다면 gender 변수에 "남자"를 넣어라.
						else gender ="여자";
						
						// 모든 체크가 끝나면 DB에 새로운 회원을 가입처리한다.
						// 회원명 중복처리
						vo = dao.getNameSearch(name);	// 여러방면에서 사용하기 편하게 vo로 가져오면 편하다.
						if(vo.getName() != null) {
							JOptionPane.showMessageDialog(null, "이미 가입된 회원입니다. 다시 입력하세요.");
							txtName.requestFocus();
						}
						else {
							// 정상적으로 자료가 입력되었다면 vo에 담아있는 값을 DB에 저장한다.
							vo.setName(name);
							vo.setAge(Integer.parseInt(age));	//위에 age가 String으로 되어있기 때문에 int로 바꿔준다.
							vo.setGender(gender);
							vo.setIpsail(ipsail);
							
							//vo에 담긴 자료를 DB에 저장시켜준다.
							res = dao.setInsaInput(vo);
							
							if(res == 0) {
								JOptionPane.showMessageDialog(null, "회원가입 실패.. 다시 가입하세요.");
								txtName.requestFocus();
							}
							else {
								JOptionPane.showMessageDialog(null, "회원에 가입되셨습니다.");
								
								// 다음 입력자료 처리를 위한 준비.... (회원가입이 완료되면 아래에 적은 메소드를 실행시켜 "다시입력"버튼을 누른 것 처럼 작성한 모든 값이 초기화 된다."
								btnReset.doClick();	//btnReset 호출... 밑에 있는 btnReset.addActionListener(new ActionListener() { 이거..
							}
						}
					}
				}
			}
		});
		
		// 다시입력 버튼
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtName.setText("");
				txtAge.setText("");
				rdMale.setSelected(true);	//초기값으로 세팅....
				
				// 오늘 날짜로 입사일을 채우기...
				InsaService service = new InsaService();
				vo = service.getDefaultDate();
				
				// vo에 가져온 날짜데이터를 날짜콤보상자에 넣어준다.
				cbYY.setSelectedItem(vo.getStrYY());
				cbMM.setSelectedItem(vo.getStrMM());
				cbDD.setSelectedItem(vo.getStrDD());
				
				txtName.requestFocus();
			}
		});
		
		// 창닫기 버튼
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		// 회원 성명 입력 후 엔터키를 누르면 커서를 나이로 이동
		txtName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) txtAge.requestFocus();
			}
		});
		
	}
}
