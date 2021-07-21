package jp.ac.hcs.gondo.domain.repository;

import java.util.List;
import java.util.Map;

abstract class RepositoryImpl<D,E> implements Repository<D,E>{

	/**
	 * @inheritDoc
	 */
	@Override
	public E findAll() {
		List<Map<String, Object>> resultSet = selectAll();
		E data = refillToData(resultSet);
		return data;
	}

	protected abstract List<Map<String, Object>> selectAll();

	protected abstract E refillToData(List<Map<String, Object>> resultSet);
	
	/**
	 * @inheritDoc
	 */
	@Override
	public E findById(int id) {
		List<Map<String, Object>> resultSet = selectOne(id);
		E data = refillToData(resultSet);
		return data;
	}
	
	protected abstract List<Map<String, Object>> selectOne(int id);
	
	/**
	 * @inheritDoc
	 */
	@Override
	public E findByName(String keyword) {
		List<Map<String, Object>> resultSet = selectKeyword(keyword);
		E data = refillToData(resultSet);
		return data;
	}
	
	protected abstract List<Map<String, Object>> selectKeyword(String keyword);
	
	/**
	 * @inheritDoc
	 */
	@Override
	public E findByUserId(String userId) {
		List<Map<String, Object>> resultSet = selectUserId(userId);
		E data = refillToData(resultSet);
		return data;
	}
	
	protected abstract List<Map<String, Object>> selectUserId(String userId);
	
	/**
	 * @inheritDoc
	 */
	@Override
	public int save(D d) {
		int count = create(d);
		return count;
	}
	
	protected abstract int create(D d);
}
