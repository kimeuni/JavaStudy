package swingEx1;

import java.time.LocalDateTime;

// 시간지연
public class Test4 {
	public static void main(String[] args) {
		while(true) {	//1초마다 현재시간이 나온다. (무한루프)
			System.out.println("현재시간 : "+ LocalDateTime.now());
			try {
				Thread.sleep(1000); // 1초 지연
			} catch (InterruptedException e) {} 
		}
	}
}
