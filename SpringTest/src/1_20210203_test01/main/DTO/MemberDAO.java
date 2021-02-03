package main.DTO;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MemberDAO {
	                   //Key     //value 
	private static Map<String, MemberDTO> map =
			new HashMap<String, MemberDTO>();
	
	private static long nextId = 0;
	
	public void insert(MemberDTO dto) {
		//사용자 저장
		dto.setId(++nextId);
		map.put(dto.getEmail(),dto);
	}
	public MemberDTO selectByemail(String eamil) {
				       //key==>value(dto)
		return map.get(eamil);
	}
	public Collection<MemberDTO> selectAll() {
		return map.values();
	}
	
}
