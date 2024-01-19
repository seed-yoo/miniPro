package add_book;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhoneBookApp {

	public static void pList(List<PhoneBook> person) {

			for (int i = 0; i < person.size(); i++) {
				person.get(i).setNum(i+1);
				person.get(i).showInfo();
				//System.out.println((i + 1) + "." + person.get(i));
		}

	}

	public static void wText(List<PhoneBook> person) {
		try {
			// ※ 주의 - 쓰기를 사용하면 원본 파일이 다 없어짐
			Writer out = new FileWriter("C:\\javaStudy\\강의자료\\01.java_programing\\미니프로젝트\\PhoneDB_원본_insert.txt");
			BufferedWriter bw = new BufferedWriter(out);

			for (int i = 0; i < person.size(); i++) {
				PhoneBook write = (PhoneBook) person.get(i);
				//person.get(i).setNum(i+1);
				bw.write(write.getName()+",");
				bw.write(write.getHp()+",");
				bw.write(write.getCompany());
				bw.newLine();
			}
			bw.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public static void rText(List<PhoneBook> person) {
		try {
			Reader fr = new FileReader("C:\\javaStudy\\강의자료\\01.java_programing\\미니프로젝트\\PhoneDB_원본.txt");
			BufferedReader br = new BufferedReader(fr);

			while (true) {
				String a = br.readLine();
				if (a == null) {
					break;
				}
				String[] str = a.split(",");

				person.add(new PhoneBook(str[0], str[1], str[2]));
			}
			br.close();

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public static void pUpdate(Scanner sc, List<PhoneBook> person) {
		
		try {
			System.out.print(">이름: ");
			String name = sc.nextLine();
			System.out.print(">휴대전화: ");
			String hp = sc.nextLine();
			System.out.print(">회사전화: ");
			String company = sc.nextLine();
			
			person.add(new PhoneBook(name, hp, company));
			
		} catch (Exception e) {
		}
		
		
	}

	public static void pRemove(Scanner sc, List<PhoneBook> person) {

		try {
			int dnum = sc.nextInt();
			
			person.remove(dnum - 1);
			
			System.out.println();
		} catch (Exception e) {
			System.out.println(e);
		}
		

	}

	public static void pSearch(Scanner sc, List<PhoneBook> person) {
		
		String name = sc.nextLine();
		
		for (int i = 0; i < person.size(); i++) {
			String pname = person.get(i).getName();
			
			if(pname.contains(name)) {
				System.out.println(pname);
			}
			
		}
	}

	public static void main(String[] args) {

		List<PhoneBook> person = new ArrayList<PhoneBook>();

		System.out.println("*******************************************");
		System.out.println("*            전화번호 관리 프로그램            *");
		System.out.println("*******************************************");
		System.out.println();

		Scanner sc = new Scanner(System.in);
		boolean tf = true;
		int count = 0;
		while (tf) {
			System.out.println("1.리스트  2.등록  3.삭제  4.검색  5.종료");
			System.out.println("------------------------------------");
			System.out.print(">메뉴번호: ");
			
			int no = sc.nextInt();
			
			switch (no) {

			case 1:
				System.out.println("<1.리스트>");
				if(count == 0) {
					rText(person);
					pList(person);
					wText(person);
					count++;
				}else {
					pList(person);
				}
				System.out.println();
				break;

			case 2:
				sc.nextLine();

				System.out.println("<2.등록>");

				pUpdate(sc, person);
				wText(person);

				System.out.println("[등록되었습니다.]");
				System.out.println();
				
				break;
			case 3:
				sc.nextLine();

				System.out.println("<3.삭제>");
				System.out.print(">번호 : ");
				pRemove(sc, person);
				wText(person);
				break;
			case 4:
				sc.nextLine();
				System.out.println("<4.검색>");
				System.out.print(">이름:");
				pSearch(sc, person);
				System.out.println();
				break;

			case 5:
				tf = false;
				System.out.println();
				System.out.println("****************");
				System.out.println("*   감사합니다   *");
				System.out.println("****************");
				break;

			default:
				System.out.println("[다시 입력해주세요.]");
				System.out.println();
				break;
			}

		}

		sc.close();
	}

}
