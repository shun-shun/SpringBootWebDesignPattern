package jp.ac.hcs.gondo.domain.repository;

import java.util.List;
import java.util.Map;

abstract class RepositoryImpl<T> implements Repository<T>{

	/**
	 * @inheritDoc
	 */
	@Override
	public T findAll() {
		List<Map<String, Object>> resultSet = selectAll();
		T data = refillToData(resultSet);
		return data;
	}

	protected abstract List<Map<String, Object>> selectAll();

	protected abstract T refillToData(List<Map<String, Object>> resultSet);
	
	/**
	 * @inheritDoc
	 */
	@Override
	public T findById(int id) {
		List<Map<String, Object>> resultSet = selectOne(id);
		T data = refillToData(resultSet);
		return data;
	}
	
	protected abstract List<Map<String, Object>> selectOne(int id);
	
	/**
	 * @inheritDoc
	 */
	@Override
	public T findByName(String keyword) {
		List<Map<String, Object>> resultSet = selectKeyword(keyword);
		T data = refillToData(resultSet);
		return data;
	}
	
	protected abstract List<Map<String, Object>> selectKeyword(String keyword);
	
	/**
	 * @inheritDoc
	 */
	@Override
	public T findByUserId(String userId) {
		List<Map<String, Object>> resultSet = selectUserId(userId);
		T data = refillToData(resultSet);
		return data;
	}
	
	protected abstract List<Map<String, Object>> selectUserId(String userId);
	
	/**
	 * @inheritDoc
	 */
	@Override
	public int save(T t) {
		int count = create(t);
		return 0;
	}
	
	protected abstract int create(T t);
}
