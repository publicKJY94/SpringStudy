package biz.member;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

// JDBCTemplate을 활용한 버전업
// 반복되는 JDBC의 로직을 캡슐화한 클래스
// 템플릿 패턴을 활용해 클래스를 구현하므로 가독성을 향상시킨다
// ⁕템플릿 패턴이란?
//	주로 반복되거나, 복잡한 로직을 캡슐화한 클래스
public class MemberDAO2 {

	@Autowired // @Autowired는 만능이 아니다
	private JdbcTemplate jdbcTemplate; // 의존관계 ▶ DI(의존주입)

	private static final String SELECTALL = "SELECT * FROM MEMBER";
	private static final String SELECTONE = "SELECT * FROM MEMBER WHERE MID=? AND PASSWORD=?";

	private static final String INSERT = "INSERT INTO MEMBER (MID,PASSWORD,NAME,ROLE) VALUES(?,?,?,?)";
	private static final String UPDATE = "";
	private static final String DELETE = "";

	// ArrayList보다 List를 훨씬 많이 사용
	// ArrayList를 List로 변경할 것
	public ArrayList<MemberDTO> selectAll(MemberDTO mDTO) {
		return (ArrayList<MemberDTO>) jdbcTemplate.query(SELECTALL, new MemberRowMapper());
	}

	public MemberDTO selectOne(MemberDTO mDTO) {
		Object[] args = { mDTO.getMid(), mDTO.getPassword() };
		return jdbcTemplate.queryForObject(SELECTONE, args, new MemberRowMapper());
	}

	public boolean insert(MemberDTO mDTO) {
		int result = jdbcTemplate.update(INSERT, mDTO.getMid(), mDTO.getPassword(), mDTO.getName(), mDTO.getRole());
		if (result <= 0) {
			return false;
		}
		return true;
	}

	public boolean update(MemberDTO mDTO) {
		int result = jdbcTemplate.update(UPDATE, mDTO.getMid(), mDTO.getPassword(), mDTO.getName(), mDTO.getRole());
		if (result <= 0) {
			return false;
		}
		return true;
	}

	public boolean delete(MemberDTO mDTO) {
		int result = jdbcTemplate.update(DELETE, mDTO.getMid(), mDTO.getPassword(), mDTO.getName(), mDTO.getRole());
		if (result <= 0) {
			return false;
		}
		return true;
	}
}

// 개발자의 편의를 위해 RowMapper 인터페이스를 사용
class MemberRowMapper implements RowMapper<MemberDTO> {
	@Override
	public MemberDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		MemberDTO data = new MemberDTO();
		data.setMid(rs.getString("MID"));
		data.setPassword(rs.getString("PASSWORD"));
		data.setName(rs.getString("NAME"));
		data.setRole(rs.getString("ROLE"));
		return data;
	}
}