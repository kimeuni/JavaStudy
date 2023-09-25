package AWT2_Adapter;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@SuppressWarnings("serial")
public class T2_ButtonEvent extends Frame {
	Button btnPlay,btnExit;		//안에 적으면 밖에서 제어를 못하기 때문에 밖에 미리 선언해주는게 좋다.
	
	public T2_ButtonEvent() {
		super("어뎁터 활용!!!");
		
		setBounds(300, 250, 300, 150);
		setLayout(new FlowLayout());
		
		btnPlay = new Button("Play");
		btnExit = new Button("Exit");
		
		add(btnPlay); // 프레임에 올려야하기 때문에 add(버튼변수명)
		add(btnExit);
		
		setVisible(true);
		////////////////////////////////////////////
		
		// btnPlay버튼 제어하기
		btnPlay.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(e.getSource()); 	// btnPlay이 버튼을 눌렀을 때 이벤트에 발생한 정보(속성?)을 볼 수 있다.
				Button btn = (Button)e.getSource();
				
				if(btn.getLabel().equals("Play")) {	// Play버튼을 누르면
					btn.setLabel("Stop");	// Stop으로 글자를 바꾼다.
					System.out.println("음악이 시작되었습니다.");
				}
				else if(btn.getLabel().equals("Stop")) {	// 대소문자 구분해서 적어야 한다.
					btn.setLabel("Play");
					System.out.println("음악이 종료되었습니다.");
				}
			}
		});
		
		// 종료버튼(btnExit)을 이용한 윈도우 종료
		btnExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("종료버튼을 눌렀습니다.");
				System.exit(0);
			}
		});
		
		// 윈도우어댑터를 이용한 윈도우 종료
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {	// 윈도우에서 발생하는 이벤트 감시
				System.exit(0);
			}
		});
	}
	
	public static void main(String[] args) {
		new T2_ButtonEvent();
	}
}
