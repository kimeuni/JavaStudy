package windowbuilder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class T04_ComboListBox extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					T04_ComboListBox frame = new T04_ComboListBox();
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
	public T04_ComboListBox() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pn1 = new JPanel();
		pn1.setBounds(12, 10, 260, 247);
		contentPane.add(pn1);
		pn1.setLayout(null);
		
		JLabel lblJob = new JLabel("직업을 선택하세요");
		lblJob.setFont(new Font("굴림", Font.PLAIN, 16));
		lblJob.setHorizontalAlignment(SwingConstants.CENTER);
		lblJob.setBounds(12, 10, 236, 36);
		pn1.add(lblJob);
		
		JComboBox comboJob = new JComboBox();
		comboJob.setFont(new Font("굴림", Font.PLAIN, 14));
		comboJob.setModel(new DefaultComboBoxModel(new String[] {"회사원", "학생", "군인", "의사", "판사", "변호사", "프리랜서", "기타"}));
		comboJob.setBounds(12, 50, 236, 36);
		pn1.add(comboJob);
		
		JList listFood = new JList();
		listFood.setFont(new Font("굴림", Font.PLAIN, 14));
		listFood.setModel(new AbstractListModel() {
			String[] values = new String[] {"짜장면", "떡볶이", "피자", "치킨", "돈까스", "제육덮밥", "탕수육", "도시락", "김밥", "샐러드", "음료수"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		listFood.setBounds(12, 106, 236, 131);
		pn1.add(listFood);
		
		JPanel pn2 = new JPanel();
		pn2.setBounds(312, 10, 260, 247);
		contentPane.add(pn2);
		pn2.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 56, 236, 181);
		pn2.add(scrollPane);
		
		JList listFood2 = new JList();
		listFood2.setFont(new Font("굴림", Font.PLAIN, 14));
		listFood2.setModel(new AbstractListModel() {
			String[] values = new String[] {"짜장면", "떡볶이", "피자", "치킨", "돈까스", "제육덮밥", "탕수육", "도시락", "김밥", "샐러드", "음료수", "커피", "라면", "찐빵"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		scrollPane.setViewportView(listFood2);
		
		JLabel lblJob_1 = new JLabel("좋아하는 음식을 선택하세요");
		lblJob_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblJob_1.setFont(new Font("굴림", Font.PLAIN, 16));
		lblJob_1.setBounds(12, 10, 236, 36);
		pn2.add(lblJob_1);
		
		JPanel pn3 = new JPanel();
		pn3.setBackground(Color.WHITE);
		pn3.setBounds(12, 326, 560, 125);
		contentPane.add(pn3);
		pn3.setLayout(null);
		
		JLabel lblMsg = new JLabel("출 력 창");
		lblMsg.setFont(new Font("굴림", Font.PLAIN, 16));
		lblMsg.setHorizontalAlignment(SwingConstants.CENTER);
		lblMsg.setBounds(12, 10, 249, 105);
		pn3.add(lblMsg);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(299, 10, 249, 105);
		pn3.add(scrollPane_1);
		
		JTextArea txtaMsg = new JTextArea();
		scrollPane_1.setViewportView(txtaMsg);
		
		JPanel pn4 = new JPanel();
		pn4.setBounds(12, 269, 560, 47);
		contentPane.add(pn4);
		pn4.setLayout(null);
		
		JButton btnCombo = new JButton("콤보출력");
		btnCombo.setFont(new Font("굴림", Font.PLAIN, 14));
		btnCombo.setBounds(0, 10, 101, 27);
		pn4.add(btnCombo);
		
		JButton btnList = new JButton("리스트 출력1");
		btnList.setFont(new Font("굴림", Font.PLAIN, 14));
		btnList.setBounds(102, 10, 117, 27);
		pn4.add(btnList);
		
		JButton btnExit = new JButton("종 료");
		btnExit.setFont(new Font("굴림", Font.PLAIN, 14));
		btnExit.setBounds(462, 10, 91, 27);
		pn4.add(btnExit);
		
		JButton btnList1 = new JButton("리스트 출력2");
		btnList1.setFont(new Font("굴림", Font.PLAIN, 14));
		btnList1.setBounds(221, 10, 117, 27);
		pn4.add(btnList1);
		
		JButton btnList2 = new JButton("리스트출력3");
		btnList2.setFont(new Font("굴림", Font.PLAIN, 14));
		btnList2.setBounds(344, 10, 117, 27);
		pn4.add(btnList2);
		
		/*----------------------------------------------------------*/
		
		// 리스트박스의 내용 하나 선택후 lblMsg에 출력하는 버튼
		btnList1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object[] foods = listFood2.getSelectedValuesList().toArray();
				String food = "";
				for(Object f : foods) food += f +"/";
				
				lblMsg.setText(food);
			}
		});
		
		// 리스트박스의 내용 하나 선택후 textArea에 출력하는 버튼
		btnList2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object[] foods = listFood2.getSelectedValuesList().toArray();
//				String food = "";
//				for(Object f : foods) {
//					food += f +"\n";
//				}
//				txtaMsg.setText(food);
				for(Object f : foods) {
					txtaMsg.append(f.toString() + "\n");
				}
			}
		});
		
		// 콤보박스 선택내용 출력처리 버튼
		btnCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String msg = comboJob.getSelectedItem().toString();	// comboJob.getSelectedItem()==> comboJob에 들어있는 항목(값을) 읽어온다. 
				lblMsg.setText(msg);	//출력하는 레이블에 msg에 값을 저장한다.
				
			}
		});
		
		// 종료버튼
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "종료합니다.","종료창",JOptionPane.WARNING_MESSAGE);
				System.exit(0);
			}
		});
		
		// 리스트박스의 내용을 출력하는 버튼
		btnList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtaMsg.append(listFood2.getSelectedValue().toString() + "\n");	//append==> 누적 추가 /  getSelectedValue는 오브젝트로 되어 있기 때문에, toString으로 "문자열"로 바꿔준다. (하나씩만 출력된다.)
				// append 대신 setText()로 적으면 1개씩 나온다 (기존에 띄운 거 덮어씌움)
			}
		});
	}
}
