package biz.board;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

public interface BoardService {
	ArrayList<BoardDTO> selectAll(BoardDTO bDTO);
	BoardDTO selectOne(BoardDTO bDTO);
	
	boolean insert(BoardDTO bDTO);
	boolean update(BoardDTO bDTO);
	boolean delete(BoardDTO bDTO);
}
