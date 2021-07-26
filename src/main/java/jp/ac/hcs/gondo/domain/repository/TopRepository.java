package jp.ac.hcs.gondo.domain.repository;

import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.ac.hcs.gondo.common.Priority;
import jp.ac.hcs.gondo.domain.entity.TodoEntity;
import jp.ac.hcs.gondo.domain.model.TodoData;

@Repository
public class TopRepository extends RepositoryImpl<TodoData, TodoEntity> {

	private static final String SELECT_ALL_SQL = "SELECT * FROM t_report";

	private static final String SELECT_BY_ID_AND_USERID_SQL = "SELECT * FROM t_report WHERE id = ? and user_id = ?";

	private static final String SELECT_BY_LIKE_SQL = "SELECT * FROM t_report WHERE title LIKE ? or contents LIKE ?";

	private static final String SELECT_BY_USER_ID_SQL = "SELECT * FROM t_report WHERE user_id = ?";

	private static final String INSERT_SQL = "INSERT INTO t_report (id, title, priority, contents, user_id, create_date, update_date) VALUES ((SELECT MAX(id) + 1 FROM t_report), ?, ?, ?, ?, ?, ?)";

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	ModelMapper modelMapper;

	@Override
	protected List<Map<String, Object>> selectAll() {
		List<Map<String, Object>> resultSet = jdbcTemplate.queryForList(SELECT_ALL_SQL);
		return resultSet;
	}

	@Override
	protected TodoEntity refillToData(List<Map<String, Object>> resultSet) {
		TodoEntity entity = new TodoEntity();
		for (Map<String, Object> m : resultSet) {
			TodoData data = modelMapper.map(m, TodoData.class);
			// enumのみ手動で設定
			data.setPriority(Priority.idOf((int) m.get("priority")));
			entity.getList().add(data);
		}
		return entity;
	}

	@Override
	protected List<Map<String, Object>> selectOne(int id, String userId) {
		List<Map<String, Object>> resultSet = jdbcTemplate.queryForList(SELECT_BY_ID_AND_USERID_SQL, id, userId);
		return resultSet;
	}

	@Override
	protected List<Map<String, Object>> selectKeyword(String keyword) {
		keyword = "%" + keyword + "%";
		List<Map<String, Object>> resultSet = jdbcTemplate.queryForList(SELECT_BY_LIKE_SQL, keyword, keyword);
		return resultSet;
	}

	@Override
	protected List<Map<String, Object>> selectUserId(String userId) {
		List<Map<String, Object>> resultSet = jdbcTemplate.queryForList(SELECT_BY_USER_ID_SQL, userId);
		return resultSet;
	}

	@Override
	protected int create(TodoData d) {
		int count = jdbcTemplate.update(INSERT_SQL,
				d.getTitle(),
				d.getPriority().getId(),
				d.getContents(),
				d.getUser_id(),
				d.getCreate_date(),
				d.getUpdate_date());
		return count;
	}

}
