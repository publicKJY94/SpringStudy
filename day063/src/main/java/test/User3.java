package test;

import java.util.ArrayList;
import java.util.Scanner;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import biz.board.BoardDTO;
import biz.board.BoardService;
import biz.member.MemberDTO;
import biz.member.MemberService;

public class User3 { // Client(브라우저)

	public static void main(String[] args) {
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");

		BoardService boardService = (BoardService) factory.getBean("boardService");
		MemberService memberService = (MemberService) factory.getBean("memberService");
		MemberDTO memberDTO = new MemberDTO();
		BoardDTO boardDTO = new BoardDTO();
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("1. 로그인");
			System.out.println("2. 회원가입");
			System.out.println("3. 전체글 출력");
			System.out.println("4. 글 작성");
			System.out.println("번호를 입력 >> ");
			int btn = sc.nextInt();
			if (btn == 1) {
				while (true) {
					System.out.print("아이디 입력 >> ");
					memberDTO.setMid(sc.next());
					System.out.println();
					System.out.print("비밀번호 입력 >> ");
					memberDTO.setPassword(sc.next());
					System.out.println();
					memberDTO = memberService.selectOne(memberDTO);
					if (memberDTO != null) {
						System.out.println(memberDTO.getName() + "님 환영합니다");
						break;
					} else {
						System.out.println("로그인에 실패했습니다");
						continue;
					}
				}
			} else if (btn == 2) {
				System.out.println("=====회원가입=====");
				System.out.print("아이디 입력 >> ");
				memberDTO.setMid(sc.next());
				System.out.println();
				System.out.print("이름 입력 >> ");
				memberDTO.setPassword(sc.next());
				System.out.println();
				System.out.print("비밀번호 입력 >> ");
				memberDTO.setName(sc.next());
				System.out.println();
				memberDTO.setRole("USER");
				boolean flag = memberService.insert(memberDTO);
				if (flag) {
					System.out.println(memberDTO.getName() + "님 회원가입에 성공했습니다");
				} else {
					System.out.println("회원가입에 실패했습니다");
				}
			} else if (btn == 3) {
				System.out.println("====글목록출력====");
				ArrayList<BoardDTO> bdatas = boardService.selectAll(boardDTO);
				for (BoardDTO data : bdatas) {
					System.out.println(data);
				}
			} else if (btn == 4) {
				if(memberDTO.getMid()!=null){
					System.out.println("=====글 작성=====");
					System.out.print("제목 입력 >> ");
					boardDTO.setTitle(sc.next());
					System.out.println();
					System.out.print("내용 입력 >> ");
					boardDTO.setContent(sc.next());
					System.out.println();
					boardDTO.setWriter(memberDTO.getMid());
					boolean flag = boardService.insert(boardDTO);
					if (flag) {
						System.out.println("작성에 성공했습니다");
					} else {
						System.out.println("작성에 실패했습니다");
					}
				}
			} else {
				System.out.println("해당서비스는 아직 구현되지 않은 서비스 입니다");
			}

			factory.close();
		}
	}

}
