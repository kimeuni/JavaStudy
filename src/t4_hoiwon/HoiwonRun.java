package t4_hoiwon;

import java.util.ArrayList;
import java.util.Scanner;

public class HoiwonRun {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		HoiwonDAO dao = new HoiwonDAO();
		boolean run = true;
		String name = "";
		HoiwonVO vo = null;
		
		while(run) {
			System.out.print("1.전체조회 2.개별조회 3:수정 4:삭제 5.종료==> ");
			int no = scanner.nextInt();
			
			switch (no) {
			case 1:
				ArrayList<HoiwonVO> vos = dao.getList();	// 전체검색 호출
				
				System.out.println("\t\t** 주 소 록 **");
				System.out.println("=".repeat(42));
				System.out.println("번호\t성명\t나이\t주소\t성별");
				System.out.println("-".repeat(42));
				for(HoiwonVO v : vos) {		//향상된 for문
//				for(int i=0; i<vos.size(); i++) {	//for문
//					vo= vos.get(i);	//for문 사용시 넣을 내용
					System.out.print(v.getIdx() + "\t");	
					System.out.print(v.getName() + "\t");
					System.out.print(v.getAge() + "\t");
					System.out.print(v.getAddress() + "\t");
					System.out.print(v.getGendser());
					System.out.println();
//				}
				}
				System.out.println("=".repeat(42));
				System.out.println("총 회원 : " + vos.size() + "명");
				
				break;
			case 2:	//개별조회
				System.out.print("검색할 회원명을 입력하세요.");
				name = scanner.next();
				System.out.println("-".repeat(40));
				vo = dao.getSearch(name);	// 개별검색 호출
				if(vo.getIdx() != 0) {	// vo로 비교하면 vo값은 null값이 되지 않기 때문에 vo != null 이런식으로 비교하면 else로 넘어가지 않는다. 그렇기 때문에 데이터 안에 있는 객체로 비교를 해야 한다.
//					System.out.println(vo);
					System.out.println("번호 : " + vo.getIdx());
					System.out.println("성명 : " + vo.getName());
					System.out.println("나이 : " + vo.getAge());
					System.out.println("주소 : " + vo.getAddress());
					System.out.println("성별 : " + vo.getGendser());
				}
				else {
					System.out.println(name + "님 자료가 없습니다.");
				}
				break;
				
			case 3:	//수정
				break;
				
			case 4: //삭제
				System.out.print("삭제할 회원명을 입력하세요.");
				name = scanner.next();
				System.out.println("-".repeat(40));
				
				vo = dao.getSearch(name);	// 개별자료 검색  / 삭제를 하기 위해서 먼저 검색을 한다. 
				if(vo.getName() == null) System.out.println(name + "님 자료가 없습니다.");
				else {
					dao.setDelete(name);
					System.out.println(name + "님 자료가 삭제되었습니다.");
				}
				break;
				
			default:
				run = false;
			}
			System.out.println("==========================================");
		}
		System.out.println("작업끝....");
		
		// DB conn객체 close
		dao.connClose();
		
		scanner.close();
	}
}
