package main.service;

import main.DTO.MemberDAO;
import main.DTO.MemberDTO;

public class MemberRegisterService {
	// 서비스에선 다오가 의존객체
	private MemberDAO dao = new MemberDAO();

	public void regist(RegisterRequest req) {
		MemberDTO dto = dao.selectByemail(req.getEmail());
		if (dto == null) {
			dto = new MemberDTO();
			dto.setEmail(req.getEmail());
			dto.setName(req.getName());
			dto.setPassword(req.getPassword());
			dao.insert(dto);
			System.out.println("사용자가 등록되었습니다.");
		}else {
			System.out.println("등록된 사용자가 있습니다.");
		}
	}
}
