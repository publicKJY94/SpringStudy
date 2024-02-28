package biz.member;

import java.util.ArrayList;

import biz.board.BoardDTO;

public interface MemberService {
	ArrayList<MemberDTO> selectAll(MemberDTO mDTO);
	MemberDTO selectOne(MemberDTO mDTO);
	
	boolean insert(MemberDTO mDTO);
	boolean update(MemberDTO mDTO);
	boolean delete(MemberDTO mDTO);
}
