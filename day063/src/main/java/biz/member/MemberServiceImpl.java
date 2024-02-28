package biz.member;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service("memberService") // 가독성 향상, 컨테이너가 같은 @끼리 잘 정리하여 보관하여 처리속도 향상
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberDAO mDAO;
	
	@Override
	public ArrayList<MemberDTO> selectAll(MemberDTO mDTO) {
		// TODO Auto-generated method stub
		return mDAO.selectAll(mDTO);
	}

	@Override
	public MemberDTO selectOne(MemberDTO mDTO) {
		// TODO Auto-generated method stub
		return mDAO.selectOne(mDTO);
	}

	@Override
	public boolean insert(MemberDTO mDTO) {
		// TODO Auto-generated method stub
		return mDAO.insert(mDTO);
	}

	@Override
	public boolean update(MemberDTO mDTO) {
		// TODO Auto-generated method stub
		return mDAO.update(mDTO);
	}

	@Override
	public boolean delete(MemberDTO mDTO) {
		// TODO Auto-generated method stub
		return mDAO.delete(mDTO);
	}

}
