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

	public static void pList() throws IOException {
		int count = 0;
		// in
		Reader fr = new FileReader("C:\\javaStudy\\강의자료\\01.java_programing\\미니프로젝트\\PhoneDB_원본.txt");
		BufferedReader br = new BufferedReader(fr);

		// ※ 주의 - 쓰기를 사용하면 원본 파일이 다 없어짐
		Writer out = new FileWriter("C:\\javaStudy\\강의자료\\01.java_programing\\미니프로젝트\\PhoneDB_원본_insert.txt");
		BufferedWriter bw = new BufferedWriter(out);

		while (true) {
			// 파일을 1줄씩 읽는다.
			String str = br.readLine();

			// null 이면 반복문 끝.
			if (str == null) {
				break;
			}
			bw.write(str);
			bw.newLine();

			System.out.println((count + 1) + ".\t" + str);
			count++;
		}

		System.out.println();

		br.close();
		bw.close();
	}

	public static void pUpdate(String info) throws IOException {
		// in
		Reader fr = new FileReader("C:\\javaStudy\\강의자료\\01.java_programing\\미니프로젝트\\PhoneDB_원본_insert.txt");
		BufferedReader br = new BufferedReader(fr);

		// ※ 주의 - 쓰기를 사용하면 원본 파일이 다 없어짐
		Writer out = new FileWriter("C:\\javaStudy\\강의자료\\01.java_programing\\미니프로젝트\\PhoneDB_원본.txt");
		BufferedWriter bw = new BufferedWriter(out);

		while (true) {
			// 파일을 1줄씩 읽는다.
			String str = br.readLine();

			// null 이면 반복문 끝.
			if (str == null) {
				break;
			}
			bw.write(str);
			bw.newLine();

		}
		bw.write(info);

		System.out.println();

		br.close();
		bw.close();
	}

	public static void pRemove(int dnum) throws IOException {
		// in
		Reader fr = new FileReader("C:\\javaStudy\\강의자료\\01.java_programing\\미니프로젝트\\PhoneDB_원본_insert.txt");
		BufferedReader br = new BufferedReader(fr);

		// ※ 주의 - 쓰기를 사용하면 원본 파일이 다 없어짐
		Writer out = new FileWriter("C:\\javaStudy\\강의자료\\01.java_programing\\미니프로젝트\\PhoneDB_원본.txt");
		BufferedWriter bw = new BufferedWriter(out);
		
		
		String str;

		
		List pList = new ArrayList();
		
		while (true) {
			// 파일을 1줄씩 읽는다.
			str = br.readLine();

			// null 이면 반복문 끝.
			if (str == null) {
				break;
			}
			bw.write(str);
			bw.newLine();

			pList.add(str);
		}
		pList.remove(dnum - 1);
		
		
		for (int j = 0; j < pList.size(); j++) {
			String a = (String) pList.get(j);
			
			bw.write(a);
			bw.newLine();
			
		}
		
		System.out.println();

		br.close();
		bw.close();
	}

	
	public static void main(String[] args) throws IOException {

		// in
		Reader fr = new FileReader("C:\\javaStudy\\강의자료\\01.java_programing\\미니프로젝트\\PhoneDB_원본.txt");
		BufferedReader br = new BufferedReader(fr);

		// ※ 주의 - 쓰기를 사용하면 원본 파일이 다 없어짐
		Writer out = new FileWriter("C:\\javaStudy\\강의자료\\01.java_programing\\미니프로젝트\\PhoneDB_원본_insert.txt");
		BufferedWriter bw = new BufferedWriter(out);

		System.out.println("*******************************************");
		System.out.println("*            전화번호 관리 프로그램            *");
		System.out.println("*******************************************");

		Scanner sc = new Scanner(System.in);
		boolean tf = true;

		while (tf) {
			System.out.println("1.리스트  2.등록  3.삭제  4.검색  5.종료");
			System.out.print(">메뉴번호: ");

			int num = sc.nextInt();

			switch (num) {

			case 1:
				System.out.println("<1.리스트>");

				pList();

				break;

			case 2:
				sc.nextLine();

				System.out.println("<2.등록>");

				System.out.print(">이름: ");
				String name = sc.nextLine();
				System.out.print(">휴대전화: ");
				String hp = sc.nextLine();
				System.out.print(">회사전화: ");
				String company = sc.nextLine();

				String info = name + "," + hp + "," + company;

				pUpdate(info);

				System.out.println("[등록되었습니다.]");

				break;
			case 3:
				sc.nextLine();

				System.out.println("<3.삭제>");
				System.out.print(">번호 : ");

				int dnum = sc.nextInt();

				pRemove(dnum);

				break;
			case 4:

				break;

			case 5:
				tf = false;
				System.out.println("****************");
				System.out.println("*   감사합니다   *");
				System.out.println("****************");
				break;

			default:
				System.out.println("[다시 입력해주세요.]");
				break;
			}

		}

		sc.close();
		bw.close();
		br.close();
	}

}
