package swingEx1;

import java.time.LocalDateTime;

// 시간지연
public class Test3 {
	public static void main(String[] args) {
		System.out.println("현재시간 : "+ LocalDateTime.now());

		
		try {
			Thread.sleep(3000); // 3초 지연
		} catch (InterruptedException e) {} 
		
		System.out.println("다음시간 : "+ LocalDateTime.now());
	}
}
