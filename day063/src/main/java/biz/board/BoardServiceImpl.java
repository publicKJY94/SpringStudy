package biz.board;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("boardService")
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDAO bDAO;
	
	@Override
	public ArrayList<BoardDTO> selectAll(BoardDTO bDTO) {
		return bDAO.selectAll(bDTO);
	}

	@Override
	public BoardDTO selectOne(BoardDTO bDTO) {
		// TODO Auto-generated method stub
		return bDAO.selectOne(bDTO);
	}

	@Override
	public boolean insert(BoardDTO bDTO) {
		// TODO Auto-generated method stub
		return bDAO.insert(bDTO);
	}

	@Override
	public boolean update(BoardDTO bDTO) {
		// TODO Auto-generated method stub
		return bDAO.update(bDTO);
	}

	@Override
	public boolean delete(BoardDTO bDTO) {
		// TODO Auto-generated method stub
		return bDAO.delete(bDTO);
	}

}
