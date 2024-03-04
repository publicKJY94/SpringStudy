package biz.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import biz.common.JDBCUtil;

@Repository("boardDAO2")
public class BoardDAO2 {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	private static final String SELECTALL = "SELECT * FROM BOARD";
	private static final String SELECTONE = "SELECT * FROM BOARD WHERE BID=?";

	private static final String INSERT = "INSERT INTO BOARD (TITLE,CONTENT,WRITER) VALUES(?,?,?)";
	private static final String UPDATE = "";
	private static final String DELETE = "";

	public ArrayList<BoardDTO> selectAll(BoardDTO bDTO) {
		return (ArrayList<BoardDTO>) jdbcTemplate.query(SELECTALL, new BoardRowMapper());
	}

	public BoardDTO selectOne(BoardDTO bDTO) {
		Object[] args = {bDTO.getBid()};
		return jdbcTemplate.queryForObject(SELECTONE, args, new BoardRowMapper());
	}

	public boolean insert(BoardDTO bDTO) {
		int result = jdbcTemplate.update(INSERT, bDTO.getTitle(), bDTO.getContent(), bDTO.getWriter());
		if(result <=0 ) {
			return false;
		}
		return true;
	}

	public boolean update(BoardDTO bDTO) {
		int result = jdbcTemplate.update(INSERT, bDTO.getTitle(), bDTO.getContent(), bDTO.getWriter());
		if(result <=0 ) {
			return false;
		}
		return true;
	}

	public boolean delete(BoardDTO bDTO) {
		int result = jdbcTemplate.update(INSERT, bDTO.getTitle(), bDTO.getContent(), bDTO.getWriter());
		if(result <=0 ) {
			return false;
		}
		return true;
	}
}
class BoardRowMapper implements RowMapper<BoardDTO>{
	@Override
	public BoardDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		BoardDTO data = new BoardDTO();
		data.setBid(rs.getInt("BID"));
		data.setTitle(rs.getString("TITLE"));
		data.setContent(rs.getString("CONTENT"));
		data.setWriter(rs.getString("WRITER"));
		return data;
	}
}
