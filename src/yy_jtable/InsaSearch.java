package yy_jtable;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

import xDatabase.InsaDAO;
import xDatabase.InsaVO;

@SuppressWarnings("serial")
public class InsaSearch extends JFrame {

	private ButtonGroup buttonGroup = new ButtonGroup();
	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtAge;
	private JRadioButton rdMale, rdFemale;
	private JButton btnUpdate, btnDelete, btnClose;
	
	InsaDAO dao = new InsaDAO();
	InsaVO vo = null;
	
	int res = 0;
	

//	public static void main(String[] args) {
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
//		new InsaSearch(InsaVO vo);	
//	}

	public InsaSearch(InsaVO vo) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setVisible(true); // 화면 띄우기

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pn1 = new JPanel();
		pn1.setBounds(12, 10, 760, 80);
		contentPane.add(pn1);
		pn1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("회 원 개 별 조 회(검색할 성명을 입력하세요)");
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
		txtName.setEditable(false);
		txtName.setFont(new Font("굴림", Font.PLAIN, 22));
		txtName.setBounds(306, 35, 346, 53);
		txtName.setText(vo.getName());	// vo에 담아온 나이 넣기
		pn2.add(txtName);
		txtName.setColumns(10);
		
		txtAge = new JTextField();
		txtAge.setFont(new Font("굴림", Font.PLAIN, 22));
		txtAge.setColumns(10);
		txtAge.setBounds(306, 119, 346, 53);
		txtAge.setText(vo.getAge() + "");	// vo에 담아온 나이 넣기 vo.getAge는 int타입이기 때문에 문자로 변환
		pn2.add(txtAge);
		
		rdMale = new JRadioButton("남 자");
		rdMale.setSelected(true);
		rdMale.setFont(new Font("굴림", Font.PLAIN, 22));
		rdMale.setBounds(306, 200, 147, 53);
		buttonGroup.add(rdMale);
		
		if(vo.getGender().equals("남자")) rdMale.setSelected(true);
		
		pn2.add(rdMale);
		
		rdFemale = new JRadioButton("여 자");
		rdFemale.setFont(new Font("굴림", Font.PLAIN, 22));
		rdFemale.setBounds(505, 200, 147, 53);
		buttonGroup.add(rdFemale);
		
		if(vo.getGender().equals("여자")) rdFemale.setSelected(true);
		
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
		
		
		String[] ymds = vo.getIpsail().substring(0,10).split("-");   // 2023-09-21 이런식으로 들어가 있음
		if(ymds[1].substring(0,1).equals("0")) ymds[1] = ymds[1].substring(1);	//데이터 베이스에서 월이 1자리이면 01,02 이런식으로 나오는데, ymds 변수 안에 들어있는 월은 1,2,3 이런식으로 나오기 때문에 이렇게 적어야 인식이 가능하다.
		if(ymds[2].substring(0,1).equals("0")) ymds[2] = ymds[2].substring(1);
		
		JComboBox cbYY = new JComboBox(yy);	// 배열 변수를 넣어준다.
		cbYY.setFont(new Font("굴림", Font.PLAIN, 20));
		cbYY.setBounds(306, 281, 81, 53);
		cbYY.setSelectedItem(ymds[0]);  // ==> 개별조회한 것에 대해 처음 가입할 때 설정한 년도를 저장해서 콤보박스에 보여준다.
		pn2.add(cbYY);
		
		JComboBox cbMM = new JComboBox(mm);	// 배열 변수를 넣어준다.
		cbMM.setFont(new Font("굴림", Font.PLAIN, 20));
		cbMM.setBounds(441, 281, 81, 53);
		cbMM.setSelectedItem(ymds[1]);
		pn2.add(cbMM);
		
		JComboBox cbDD = new JComboBox(dd);	// 배열 변수를 넣어준다.
		cbDD.setFont(new Font("굴림", Font.PLAIN, 20));
		cbDD.setBounds(571, 281, 81, 53);
		cbDD.setSelectedItem(ymds[2]);
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
		
		btnUpdate = new JButton("수 정 하 기");
		btnUpdate.setFont(new Font("굴림", Font.PLAIN, 20));
		btnUpdate.setBounds(70, 10, 159, 60);
		pn3.add(btnUpdate);
		
		btnDelete = new JButton("삭 제 하 기");
		btnDelete.setFont(new Font("굴림", Font.PLAIN, 20));
		btnDelete.setBounds(299, 10, 159, 60);
		pn3.add(btnDelete);
		
		btnClose = new JButton("창 닫 기");
		btnClose.setFont(new Font("굴림", Font.PLAIN, 20));
		btnClose.setBounds(528, 10, 159, 60);
		pn3.add(btnClose);
		
		/*----------------------------------------------------------------*/
		
		// 회원정보수정 버튼
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String age = txtAge.getText();
				String gender;
				String ipsaile = cbYY.getSelectedItem() + "-" + cbMM.getSelectedItem() + "-" + cbDD.getSelectedItem();
				
				if(age.trim().equals("")) {
					JOptionPane.showMessageDialog(null, "나이를 입력하세요.");
					txtAge.requestFocus();
				}
				else {
					if(rdMale.isSelected()) gender = "남자";
					else gender = "여자";
					
					// 정상적으로 수정할 자료가 입력되어 넘어온다면 모든값을 vo에 담아서 DB에 저장처리한다.
					vo.setName(txtName.getText());	// 받은 이름을 vo에 저장
					vo.setAge(Integer.parseInt(age));	//age를 String으로 만들었기 때문에 Integer.parseInt를 적어야 한다.
					vo.setGender(gender);
					vo.setIpsail(ipsaile);
					
					res = dao.setInsaUpdate(vo);
					if(res == 0) {
						JOptionPane.showMessageDialog(null, "회원정보 수정 실패.. 다시 확인하세요.");
					}
					else {
						JOptionPane.showMessageDialog(null, "회원정보가 수정되었습니다.");
					}	
				}
			}
		});
		
		// 삭제 버튼
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = txtName.getText();
//				System.out.println("name : " + name);  // 오류가 떠서 값이 제대로 넘어왔는지 확인용 (확인 후에는 지워준다.)
				int ans = JOptionPane.showConfirmDialog(null, name +"회원을 삭제하시겠습니까?","회원삭제",JOptionPane.YES_NO_OPTION);
				if(ans == 0) {
					res = dao.setInsaDelete(name);
					if(res == 0) {
						JOptionPane.showMessageDialog(null, "회원정보 삭제 실패.. 다시 확인하세요.");
					}
					else {
						JOptionPane.showMessageDialog(null, "회원정보가 삭제되었습니다.");
						dispose();
					}	
				}
				else {
					JOptionPane.showMessageDialog(null, "회원삭제 취소");
				}
			}
		});
		
		// 창닫기 버튼
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}
}
