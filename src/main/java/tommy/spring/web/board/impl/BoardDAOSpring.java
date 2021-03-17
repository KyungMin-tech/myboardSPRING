package tommy.spring.web.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import tommy.spring.web.board.BoardVO;

@Repository
public class BoardDAOSpring {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private final String BOARD_INSERT = "insert into myboard(seq, title, writer, content) "
			+ "values((select nvl(max(seq), 0)+1 from myboard), ?, ?, ?)";
	private final String BOARD_UPDATE = "update myboard set title=?, content=? where seq=?";
	private final String BOARD_DELETE = "delete myboard where seq=?";
	private final String BOARD_GET = "select * from myboard where seq=?";
	private final String BOARD_LIST = "select * from myboard order by seq desc";
	
	public void insertBoard(BoardVO vo) {
		System.out.println("Spring JDBC�� insertBoard() ��� ó��");
		jdbcTemplate.update(BOARD_INSERT, vo.getTitle(), vo.getWriter(), vo.getContent());
	}

	public void updateBoard(BoardVO vo) {
		System.out.println("Spring JDBC�� updateBoard() ��� ó��");
		jdbcTemplate.update(BOARD_UPDATE, vo.getTitle(), vo.getContent(), vo.getSeq());
	}

	public void deleteBoard(BoardVO vo) {
		System.out.println("Spring JDBC�� deleteBoard() ��� ó��");
		jdbcTemplate.update(BOARD_DELETE, vo.getSeq());
	}

	public BoardVO getBoard(BoardVO vo) {
		System.out.println("Spring JDBC�� getBoard() ��� ó��");
		Object[] args = { vo.getSeq() };
		return jdbcTemplate.queryForObject(BOARD_GET, new BoardRowMapper(), args);
	}

	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("Spring JDBC�� getBoardList() ��� ó��");
		return jdbcTemplate.query(BOARD_LIST, new BoardRowMapper());
	}
}