package jp.ac.hcs.gondo.domain.repository;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.ac.hcs.gondo.domain.entity.ReportEntity;
import jp.ac.hcs.gondo.domain.model.ReportData;

@Repository
public class TopRepository extends RepositoryImpl<ReportEntity>{

	private static final String SELECT_ALL_SQL = "SELECT * FROM t_report";
	
	private static final String SELECT_BY_ID_SQL = "SELECT * FROM t_report WHERE applyId = ?";
	
	private static final String SELECT_BY_LIKE_SQL = "SELECT * FROM t_report WHERE className LIKE ?";

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	protected List<Map<String, Object>> selectAll() {
		List<Map<String, Object>> resultSet = jdbcTemplate.queryForList(SELECT_ALL_SQL);
		return resultSet;
	}

	@Override
	protected ReportEntity refillToData(List<Map<String, Object>> resultSet) {
		ReportEntity entity = new ReportEntity();
		for(Map<String, Object> m : resultSet ) {
			ReportData data = new ReportData();
			data.setApplyId((int) m.get("applyId"));
			data.setClassName((String) m.get("className"));
			entity.getList().add(data);
		}
		return entity;
	}
	
	@Override
	protected List<Map<String, Object>> selectOne(String id) {
		List<Map<String, Object>> resultSet = jdbcTemplate.queryForList(SELECT_BY_ID_SQL, id);
		return resultSet;
	}

	@Override
	protected List<Map<String, Object>> selectKeyword(String keyword) {
		keyword = "%" + keyword + "%";
		List<Map<String, Object>> resultSet = jdbcTemplate.queryForList(SELECT_BY_LIKE_SQL, keyword);
		return resultSet;
	}

}
