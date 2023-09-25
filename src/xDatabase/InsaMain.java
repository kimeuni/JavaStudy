package xDatabase;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.lang.StackWalker.Option;
import java.awt.event.ActionEvent;

public class InsaMain extends JFrame {

	private JPanel contentPane;
	private JButton btnInput, btnSearch, btnList, btnExit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InsaMain frame = new InsaMain();
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
	public InsaMain() {
		setTitle("인사관리 메뉴");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pn1 = new JPanel();
		pn1.setBounds(12, 10, 760, 73);
		contentPane.add(pn1);
		pn1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("인사 관리 프로그램 (v1.0)");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 28));
		lblNewLabel.setBounds(12, 10, 736, 53);
		pn1.add(lblNewLabel);
		
		JPanel pn2 = new JPanel();
		pn2.setBounds(12, 93, 760, 375);
		contentPane.add(pn2);
		pn2.setLayout(null);
		
		JLabel lblMain = new JLabel("");
		lblMain.setIcon(new ImageIcon(InsaMain.class.getResource("/xDatabase/images/main.jpg")));
		lblMain.setHorizontalAlignment(SwingConstants.CENTER);
		lblMain.setBounds(0, 0, 760, 375);
		pn2.add(lblMain);
		
		JPanel pn3 = new JPanel();
		pn3.setBounds(12, 478, 760, 73);
		contentPane.add(pn3);
		pn3.setLayout(null);
		
		btnInput = new JButton("사원등록");
		btnInput.setFont(new Font("굴림", Font.PLAIN, 16));
		btnInput.setBounds(40, 10, 140, 53);
		pn3.add(btnInput);
		
		btnSearch = new JButton("개별조회");
		btnSearch.setFont(new Font("굴림", Font.PLAIN, 16));
		btnSearch.setBounds(220, 10, 140, 53);
		pn3.add(btnSearch);
		
		btnList = new JButton("전체조회");
		btnList.setFont(new Font("굴림", Font.PLAIN, 16));
		btnList.setBounds(400, 10, 140, 53);
		pn3.add(btnList);
		
		btnExit = new JButton("종료");
		btnExit.setFont(new Font("굴림", Font.PLAIN, 16));
		btnExit.setBounds(580, 10, 140, 53);
		pn3.add(btnExit);
		
		/*-------------------------------------------------------------------*/
		
		// 사원 등록 버튼을 마우스로 클릭했을 때 수행..
		btnInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new InsaInput();
			}
		});
		// 사원 등록 버튼을 키보드로 (엔터키를)눌렀을 때 수행..
		btnInput.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) new InsaInput();
			}
		});
		
		
		// 개별 사원 조회 버튼
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// insaSearch()에 들어가기 전.. 회원명이 존재하는지 확인하고 들어간다.
				String name = JOptionPane.showInputDialog("검색할 성명을 입력하세요?");
				InsaDAO dao = new InsaDAO();
				InsaVO vo = dao.getNameSearch(name);
				
				if(vo.getName() == null) JOptionPane.showMessageDialog(null, "검색한 회원이 없습니다.");
				else new InsaSearch(vo);
			}
		});
		
		
		// 전체 사원 조회 버튼
		btnList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new InsaList();
			}
		});
		
		
		// 종료 버튼을 마우스로 클릭했을 때 수행처리
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		//종료 버튼을 키보드 엔터키를 눌렀을 때 수행처리
		btnExit.addKeyListener(new KeyAdapter() {
//			@Override
//			public void keyReleased(KeyEvent e) {}	//키를 땔 때 수행
			
			@Override
			public void keyPressed(KeyEvent e) {	//키를 눌렀을 때 수행
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {	// 엔터키를 눌렀을 때....  (이걸 안적으면 아무키나 눌렀을 때 꺼짐)
					System.exit(0);
				}
		}
		
		});
		
	}

}
