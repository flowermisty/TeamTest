package main;

import java.util.Scanner;

import main.service.MemberListPrinter;
import main.service.MemberRegisterService;
import main.service.RegisterRequest;

public class App {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("명령어를 입력하세요");
			String command = sc.nextLine();
			if (command.startsWith("new")) {
				String arg[] = command.split(" ");
				//new     이름       이메일      비밀번호    비밀번호 확인
				//arg[0] arg[1] arg[2] arg[3] arg[4]
				if (arg.length != 5) {
					printhelp();
					continue;

				}
				//의존객체
				//클래스 내에 있는 객체
				RegisterRequest req = new RegisterRequest();
				req.setEmail(arg[1]);
				req.setName(arg[2]);
				req.setPassword(arg[3]);
				req.setConfirmPassword(arg[4]);
				boolean bl = req.isPasswordEqualConfirmPassword();
				if(!bl) {
					System.out.println("비밀번호가 일치하지 않습니다.");
					continue;
				}
				MemberRegisterService mrs = new MemberRegisterService();
				mrs.regist(req);
			}else if(command.equals("list")) {
				//의존객체
				MemberListPrinter listPrint =
						new MemberListPrinter();
				listPrint.printAll();
			}

		}

	}
	public static void printhelp() {
		System.out.println("명령어 사용법");
		System.out.println("new 이메일 이름 암호 암호확인");
	}
}
