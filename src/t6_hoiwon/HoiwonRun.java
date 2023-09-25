package t6_hoiwon;

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
			System.out.print("1.전체조회 2.개별조회 3.회원가입 4:수정 5:삭제 6.종료==> ");
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
				
			case 3:	//회원가입
				vo = new HoiwonVO();	// 위에서 vo를 생성한 적이 없어서 여기서 생성한다 / 만약 맨 위 (전역필드)에서 생성한 적 있다면 여기서 new로 생성하지 않고 바로 사용 가능하다. 
				// 전역필드에서 new로 vo를 생성하지 않은 이유는 사용할지 안할지도 모르는 객체를 만들어놓으면 메모리가 낭비되기 때문이다.
				while(true) {
					System.out.print("회원 성명을 입력하세요? ");
					name = scanner.next();
					
					// 성명 중복 체크....
					vo = dao.getSearch(name);	// 성명 중복 체크
					if(vo.getName() == null) break;
					System.out.println("같은 이름이 존재합니다. 다시 입력하세요.");
				}
				vo.setName(name);
				System.out.print("회원 나이를 입력하세요? ");
				vo.setAge(scanner.nextInt());
				System.out.print("회원 주소를 입력하세요? ");
				vo.setAddress(scanner.next());
				System.out.print("회원 성별을 입력하세요? (1:남자, 2:여자)");
				int gender = scanner.nextInt();	// 데이터베이스에서 gender는 char이고 여기서는 int로 받았기 때문에 <가공처리>한다.
				if(gender == 1) vo.setGendser("남자");	// 데이터베이스는 그대로 두고 여기서 가공처리 한다.
				else vo.setGendser("여자");
				
				int res = dao.setHoiwonInput(vo);	// 회원가입 메소드 호출
				if(res == 0) System.out.println("회원에 가입 실패~~.");
				else System.out.println("회원에 가입되셨습니다.");
				
				
				
				break;
				
			case 4:	//수정
				System.out.print("수정할 회원명을 입력하세요.");
				name = scanner.next();
				System.out.println("-".repeat(40));
				
				boolean flag = true;
				while(flag) {
					vo = dao.getSearch(name);	// 개별자료 검색  / 수정을 하기 위해서 먼저 검색을 한다. 
					if(vo.getName() == null) System.out.println(name + "님 자료가 없습니다.");	//이렇게 적어놓으면 무한루프를 돈다... 무한루프 안도는 방법은 t7_hoiwon / HoiwonRun에서 확인가능
					else {
						System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
						System.out.println("성명 : " + vo.getName());
						System.out.println("나이 : " + vo.getAge());
						System.out.println("주소 : " + vo.getAddress());
						System.out.println("성별 : " + vo.getGendser());
						System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
						System.out.println("수정할 항목의 번호를 입력하세요?");
						System.out.print("1:나이 2:주소 3:성별 4: 수정종료 ==> ");
						no = scanner.nextInt();
						
						int age = vo.getAge();
						String address = vo.getAddress();
						String strGender = vo.getGendser();
						switch (no) {
						case 1:
							System.out.print("수정할 나이를 입력하세요? ");
							age = scanner.nextInt();
							break;
						case 2:
							System.out.print("수정할 주소를 입력하세요? ");
							address = scanner.next();
							
							break;
						case 3:
							System.out.print("수정할 성별를 입력하세요? (1:남자 2:여자)");
							gender = scanner.nextInt();
							if(gender == 1) strGender = "남자";
							else strGender ="여자";
							
							break;
	
						default:
							flag = false;	//while문 빠져나가기
						}
						
						res = dao.setHoiwonUpdata(name,age,address,strGender);
						if(res == 0) System.out.println("수정 실패");
						else System.out.println(name + "님 자료가 수정되었습니다.");
					}
				}
				break;
				
			case 5: //삭제
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
