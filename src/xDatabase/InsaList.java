package xDatabase;

import java.awt.EventQueue;
import java.awt.Font;
import java.util.Vector;
import java.util.regex.Pattern;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import xDatabase.InsaDAO;
import xDatabase.InsaVO;

import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class InsaList extends JFrame {

	private JPanel contentPane;
	private JTable tbl;
	private JScrollPane sp; 
	private ButtonGroup genderGroup = new ButtonGroup();
	private JRadioButton rdMale, rdFemale;
	private JButton btnConditon, btnList, btnExit;
	private JComboBox cbCondition;
	
	Vector title, vData;
	
	DefaultTableModel dtm;
	
	InsaDAO dao = new InsaDAO();
	private JTextField txtCondition;
	
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					InsaList frame = new InsaList();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	@SuppressWarnings("unchecked")
	public InsaList() {
		setTitle("JTable 연습(DB에서 값을 가져와서 JTable에 뿌리기)");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600);
		setLocationRelativeTo(null);
		
		setVisible(true);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pn1 = new JPanel();
		pn1.setBounds(12, 10, 760, 66);
		contentPane.add(pn1);
		pn1.setLayout(null);
		
		btnExit = new JButton("종 료");
		btnExit.setFont(new Font("굴림", Font.PLAIN, 18));
		btnExit.setBounds(579, 9, 169, 46);
		pn1.add(btnExit);
		
		cbCondition = new JComboBox();
		cbCondition.setFont(new Font("굴림", Font.PLAIN, 18));
		cbCondition.setModel(new DefaultComboBoxModel(new String[] {"성명", "나이", "성별", "입사일"}));
		cbCondition.setBounds(12, 10, 98, 45);
		pn1.add(cbCondition);
		
		txtCondition = new JTextField();
		txtCondition.setHorizontalAlignment(SwingConstants.CENTER);
		txtCondition.setFont(new Font("굴림", Font.PLAIN, 16));
		txtCondition.setBounds(122, 10, 163, 47);
		pn1.add(txtCondition);
		txtCondition.setColumns(10);
		
		btnConditon = new JButton("조건검색");
		btnConditon.setBounds(291, 9, 87, 47);
		pn1.add(btnConditon);
		
		btnList = new JButton("전 체 검 색");
		btnList.setFont(new Font("굴림", Font.PLAIN, 18));
		btnList.setBounds(400, 9, 169, 46);
		pn1.add(btnList);
		
		JPanel pn2 = new JPanel();
		pn2.setBounds(12, 87, 760, 388);
		contentPane.add(pn2);
		pn2.setLayout(null);
		
		JPanel pn3 = new JPanel();
		pn3.setBounds(12, 485, 760, 66);
		contentPane.add(pn3);
		pn3.setLayout(null);
		
		JButton btnNameAsc = new JButton("성명 오름차순");
		btnNameAsc.setBounds(205, 10, 130, 23);
		pn3.add(btnNameAsc);
		
		JButton btnNameDesc = new JButton("성명 내림차순");
		btnNameDesc.setBounds(205, 43, 130, 23);
		pn3.add(btnNameDesc);
		
		JButton btnIpsailAsc = new JButton("입사일 오름차순");
		btnIpsailAsc.setBounds(349, 10, 130, 23);
		pn3.add(btnIpsailAsc);
		
		JButton btnIpsailDesc = new JButton("입사일 내림차순");
		btnIpsailDesc.setBounds(349, 43, 130, 23);
		pn3.add(btnIpsailDesc);
		
		rdMale = new JRadioButton("남자");
		rdMale.setBounds(30, 10, 60, 23);
		genderGroup.add(rdMale);
		pn3.add(rdMale);
		
		rdFemale = new JRadioButton("여자");
		rdFemale.setBounds(30, 43, 54, 23);
		genderGroup.add(rdFemale);
		pn3.add(rdFemale);
		
		JButton btnGenderSearch = new JButton("성별검색");
		btnGenderSearch.setBounds(96, 10, 97, 56);
		pn3.add(btnGenderSearch);
		
		/* JTable 설계하기 (JTable은 초장기 버전이기 때문에 ArrayList가 없다.. 그래서 Vector를 사용)*/
		// - '부제목'과 '데티어'를 Vector타입으로 준비한다.
		
		// 1. '부제목'을 Vector타입으로 준비
		title = new Vector<>();
		title.add("번호");
		title.add("성명");
		title.add("나이");
		title.add("성별");
		title.add("입사일");
		
		// 2. '데이터'를 Vector타입으로 준비한다. 데이터는 Database에서 가져온다.
		vData = dao.getInsaList();
		
		// 3. DB에서 가져온 자료를 DefaultTableModel을 생성하면서 담아준다.
		dtm = new DefaultTableModel(vData, title);
		
		// 4. DefaultTableModel에 담긴 Vector형식의 자료와 타이틀로 JTable을 생성시켜준다. (생성시 담아준다.)
		tbl = new JTable(dtm);
		
		// 5. 자료가 담긴 table을 JScrollPane생성시에 함께 담아서 생성한다.
		sp = new JScrollPane(tbl);
		sp.setBounds(12, 10, 736, 368);
		
		// 6. JscrollPane을 패널에 올려준다.
		pn2.add(sp);
		
		// JTable안의 셀의 내용을 가운데 정렬하기
		tableCellAlign(tbl);	//JTable의 내용을 넘겨서 (tbl = new JTable(dtm);이걸 보면JTable의 내용을 tbl에 넘겼기 때문에 tbl을 적는다)
		
		// 0번열(idx(고유번호)) 셀의 크기를 50픽셀로 조정하기
		tbl.getColumnModel().getColumn(0).setMaxWidth(50);	//tbl.getColumnModel()==> 모델링 새로 한다는 의미 getColumn(0)==> 0번열에 있는 것을 ==> setMaxWidth(50) 50픽셀로 줄임
		
		/* ======================================================================= */
		
		
		
		// 성별버튼 클릭시 성별별로 조회하기
		// 남자 라디오 버튼 클릭시 남자만 검색처리
		/*
		rdMale.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				vData = dao.getGenderMale();
				vData = dao.getGender("남자");
				dtm.setDataVector(vData, title);
			}
		});
		
		// 여자 라디오 버튼 클릭시 남자만 검색처리
		rdFemale.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				vData = dao.getGenderFemale();
				vData = dao.getGender("여자");
				dtm.setDataVector(vData, title);
			}
		});
		*/
		
		// 성별라디오 버튼으로 성별을 선택 후 '성별버튼'클릭시 해당 자료만 검색처리 후 출력하기
		btnGenderSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String gender;
				if(rdMale.isSelected()) gender = "남자";
				else gender = "여자";
				vData = dao.getGender(gender);
				dtm.setDataVector(vData, title);
				
				tableCellAlign(tbl);	// 만든 메소드 마다 이것과 밑에 것을 적어줘야 정렬 및 크기 조정된게 적용된다....
				tbl.getColumnModel().getColumn(0).setMaxWidth(50);
			}
		});
		
		
		// 입사일 오름차순 정리
		btnIpsailAsc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vData = dao.getNameAscList("ipsail", "a");
				dtm.setDataVector(vData, title);
				tableCellAlign(tbl);
				tbl.getColumnModel().getColumn(0).setMaxWidth(50);
			}
		});
		
		// 입사일 내림차순 정리
		btnIpsailDesc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vData = dao.getNameAscList("ipsail", "d");
				dtm.setDataVector(vData, title);
				tableCellAlign(tbl);
				tbl.getColumnModel().getColumn(0).setMaxWidth(50);
			}
		});
		
		// 성명 오름차순
		btnNameAsc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vData = dao.getNameAscList("name","a"); // 확장성을 고려해서 <필드값>을 넘김	// 무조건 Vector로 가져와야 함.
				dtm.setDataVector(vData, title);// 이미 생성이 되어있기 때문에 새로 생성하는게 아니라 얕은 복사를 사용한다.  // (값, 제목(타이틀))을 넘긴다.
				tableCellAlign(tbl);
				tbl.getColumnModel().getColumn(0).setMaxWidth(50);
			}
		});
		
		// 성명 내림차순
		btnNameDesc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vData = dao.getNameAscList("name","d"); // 확장성을 고려해서 <필드값>을 넘김	// 무조건 Vector로 가져와야 함.
				dtm.setDataVector(vData, title);// 이미 생성이 되어있기 때문에 새로 생성하는게 아니라 얕은 복사를 사용한다.  // (값, 제목(타이틀))을 넘긴다.
				tableCellAlign(tbl);
				tbl.getColumnModel().getColumn(0).setMaxWidth(50);
			}
		});
		
		
		// table안의 셀을 클릭할 때 입력된 정보 가져오기
		tbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = tbl.getSelectedRow(); 	//행의 정보를 한 줄 가져온다.
				int col = tbl.getSelectedColumn();	//열의 정보를 가져온다.
				
				Object value= tbl.getValueAt(row, col);	// 해오가 열의 정보를 가져와 object로 반환
						
//				lblMsg.setText("row :" + row + ", col :" + col + ", value : "+ value);
			}
		});
		
		// 조건별 검색처리 (조건버튼 클릭시 처리할 내용들)
		btnConditon.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				getConditionProcess();
			}
		});

		// 조건검색항목 선택후, 조건에 필요한 검색어를 입력후 엔터키를 누르면 바로 검색실행 처리하고자 한다.
		txtCondition.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) getConditionProcess();
			}
		});
		
		// 전체 조회버튼 클릭시 실행
		btnList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vData = dao.getInsaList();
				dtm.setDataVector(vData, title);
				tableCellAlign(tbl);
				tbl.getColumnModel().getColumn(0).setMaxWidth(50);
			}
		});
		
		// 조건검색 콤보박스 안의 항목을 변경할때마다 자동으로 커서를 입력 텍스트필드로 이동시키고자할 경우...
		cbCondition.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				txtCondition.requestFocus();
			}
		});
		
		
		// 종료 버튼
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}

	private void tableCellAlign(JTable tbl) {
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(SwingConstants.CENTER);	// 센터로 정렬 시키자(가운데정렬)	//모델링만 해놓은 상태
		
		TableColumnModel tcm = tbl.getColumnModel();	//tbl에 있는 자료를 tcm으로 꺼내온다.
		
		for(int i=0; i<tcm.getColumnCount(); i++) {
			tcm.getColumn(i).setCellRenderer(dtcr);	// 하나하나를 모두 비교해서 가운데 정렬 시킴.
		}
		
	}

	// 조건검색항목 선택후, 조건 입력필드에서 조건입력후 엔터키를 누르거나, 또는 '조건버튼'을 클릭하면 수행처리 할 내용.
	protected void getConditionProcess() {
		String cbCondi = cbCondition.getSelectedItem().toString();
		String txtCondi = txtCondition.getText();
		
		if(cbCondi.trim().equals("")) {
			JOptionPane.showMessageDialog(null, "검색할 내용을 입력하세요.");
			txtCondition.requestFocus();
			return;	//끝냄
		}
		if(cbCondi.equals("성명")) vData = dao.getConditionSearch("name",txtCondi);		 // 위에서 retrun으로 끝냈기 때문에 여기 내려오는건 무조건 거짓인 것만 넘어와서 else if를 사용할 필요가 없다.
		else if(cbCondi.equals("나이")) {
			if(!Pattern.matches("^[0-9]*$", txtCondi)) {	//숫자가 아니면
				JOptionPane.showMessageDialog(null, "나이는 숫자로 입력하세요.");
				txtCondition.requestFocus();
			}
			else vData = dao.getConditionSearch("age",txtCondi);
		}
		else if(cbCondi.equals("성별")) vData = dao.getConditionSearch("gender",txtCondi);
		else if(cbCondi.equals("입사일")) vData = dao.getConditionSearch("ipsail",txtCondi);	//이렇게 적으면 문제가 있음 (05라고 적으면 05월달인지 05일인지 2005년인지 알 수 없음(전부 나옴))
		
		dtm.setDataVector(vData, title);
		
		// 셀을 중앙정렬하고 0열의 크기를 50픽셀로 조정한다.
		tableCellAlign(tbl);
		tbl.getColumnModel().getColumn(0).setMaxWidth(50);
	}
}
