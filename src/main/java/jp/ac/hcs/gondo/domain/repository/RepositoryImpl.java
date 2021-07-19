package jp.ac.hcs.gondo.domain.repository;

import java.util.List;
import java.util.Map;

abstract class RepositoryImpl<T> implements Repository<T>{

	@Override
	public T findAll() {
		List<Map<String, Object>> resultSet = selectAll();
		T data = refillToData(resultSet);
		return data;
	}

	protected abstract List<Map<String, Object>> selectAll();

	protected abstract T refillToData(List<Map<String, Object>> resultSet);
	
	@Override
	public T findById(String id) {
		List<Map<String, Object>> resultSet = selectOne(id);
		T data = refillToData(resultSet);
		return data;
	}
	
	protected abstract List<Map<String, Object>> selectOne(String id);
	
	
	@Override
	public T findByName(String keyword) {
		List<Map<String, Object>> resultSet = selectKeyword(keyword);
		T data = refillToData(resultSet);
		return data;
	}
	
	protected abstract List<Map<String, Object>> selectKeyword(String keyword);
}
