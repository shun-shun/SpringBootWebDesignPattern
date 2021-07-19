package jp.ac.hcs.gondo.domain.repository;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.ac.hcs.gondo.domain.model.ReportData;
import jp.ac.hcs.gondo.domain.model.ReportEntity;

@Repository
public class TopRepository extends RepositoryImpl<ReportEntity>{

	static final String SQL = "SELECT * FROM t_report";

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	protected List<Map<String, Object>> selectAll() {
		List<Map<String, Object>> resultSet = jdbcTemplate.queryForList(SQL);
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

}
