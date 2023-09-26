package y_jtable;

import java.awt.EventQueue;
import java.awt.Font;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import xDatabase.InsaDAO;
import xDatabase.InsaVO;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class T1 extends JFrame {

	private JPanel contentPane;
	private JTable tbl;
	private JScrollPane sp; 
	
//	Vector<String> title = null;
//	Vector<String> vData = null;
	
	Vector title, vData;
	
	DefaultTableModel dtm;
	
	// xDatabase패키지의 InsaDAO클래스 참조... (import)
	InsaDAO dao = new InsaDAO();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					T1 frame = new T1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	@SuppressWarnings("unchecked")
	public T1() {
		setTitle("JTable 연습(DB에서 값을 가져와서 JTable에 뿌리기)");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 480);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pn1 = new JPanel();
		pn1.setBounds(12, 10, 560, 66);
		contentPane.add(pn1);
		pn1.setLayout(null);
		
		JButton btnExit = new JButton("종 료");
		btnExit.setFont(new Font("굴림", Font.PLAIN, 18));
		btnExit.setBounds(379, 10, 169, 46);
		pn1.add(btnExit);
		
		JButton btnNewWindow = new JButton("새창에 선택값 띄우기");
		btnNewWindow.setFont(new Font("굴림", Font.PLAIN, 13));
		btnNewWindow.setBounds(12, 10, 169, 46);
		pn1.add(btnNewWindow);
		
		JPanel pn2 = new JPanel();
		pn2.setBounds(12, 87, 560, 268);
		contentPane.add(pn2);
		pn2.setLayout(null);
		
//		JScrollPane scrollPane = new JScrollPane();
//		scrollPane.setBounds(12, 10, 536, 248);
//		pn2.add(scrollPane);
//		
//		tbl = new JTable();
//		scrollPane.setViewportView(tbl);
		
		JPanel pn3 = new JPanel();
		pn3.setBounds(12, 365, 560, 66);
		contentPane.add(pn3);
		pn3.setLayout(null);
		
		JLabel lblMsg = new JLabel("JTable에서 선택된 값을 출력합니다.");
		lblMsg.setHorizontalAlignment(SwingConstants.CENTER);
		lblMsg.setFont(new Font("굴림", Font.PLAIN, 16));
		lblMsg.setBounds(12, 10, 536, 46);
		pn3.add(lblMsg);
		
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
		sp.setBounds(12, 10, 536, 248);
		
		// 6. JscrollPane을 패널에 올려준다.
		pn2.add(sp);
		
		
		/* ======================================================================= */
		
		// table안의 셀을 클릭할 때 입력된 정보 가져오기
		tbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = tbl.getSelectedRow(); 	//행의 정보를 한 줄 가져온다.
				int col = tbl.getSelectedColumn();	//열의 정보를 가져온다.
				
				Object value= tbl.getValueAt(row, col);	// 해오가 열의 정보를 가져와 object로 반환
						
				lblMsg.setText("row :" + row + ", col :" + col + ", value : "+ value);
			}
		});
		
		// 테이블 클릭시 화면 띄우기.
		tbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				InsaVO vo = new InsaVO();
				int row = tbl.getSelectedRow();
				
				vo.setIdx((int)tbl.getValueAt(row, 0));	//내가 선택한 행에.. 일련번호	//언박싱
				vo.setName(tbl.getValueAt(row, 1).toString());	//이름
				vo.setAge((int)tbl.getValueAt(row, 2));			//나이
				vo.setGender(tbl.getValueAt(row, 3).toString());//성별
				vo.setIpsail(tbl.getValueAt(row, 4).toString().substring(0,10));//입사일
				
				new InsaSearch(vo);
			}
		});
		
		// 새창에 선택된 행의 정보 출력하기 버튼
		btnNewWindow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InsaVO vo = new InsaVO();
				int row = tbl.getSelectedRow();
				
				vo.setIdx((int)tbl.getValueAt(row, 0));	//내가 선택한 행에.. 일련번호	//언박싱
				vo.setName(tbl.getValueAt(row, 1).toString());	//이름
				vo.setAge((int)tbl.getValueAt(row, 2));			//나이
				vo.setGender(tbl.getValueAt(row, 3).toString());//성별
				vo.setIpsail(tbl.getValueAt(row, 4).toString().substring(0,10));//입사일
				
				new InsaSearch(vo);
			}
		});
		
		// 종료 버튼
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
}
