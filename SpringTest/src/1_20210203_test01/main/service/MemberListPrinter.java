package main.service;

import java.util.Collection;

import main.DTO.MemberDAO;
import main.DTO.MemberDTO;

public class MemberListPrinter {
	MemberDAO dao = new MemberDAO();

	public void printAll() {
		Collection<MemberDTO> list = dao.selectAll();
		for (MemberDTO dto : list) {
			System.out.printf("회원정보는 : 아이디 =%d, 이메일 =%s, 이름 = %s, 등록일 =%tF \n", 
			dto.getId(), dto.getEmail(),dto.getName(), dto.getRegisterDate());

		}

	}
}
