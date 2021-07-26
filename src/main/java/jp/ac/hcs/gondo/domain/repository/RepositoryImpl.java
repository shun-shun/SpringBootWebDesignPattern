package jp.ac.hcs.gondo.domain.repository;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

abstract class RepositoryImpl<D,E> implements Repository<D,E>{

	/**
	 * @inheritDoc
	 */
	@Override
	public E findAll() throws DataAccessException{
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
	public E findById(int id, String userId) throws DataAccessException{
		List<Map<String, Object>> resultSet = selectOne(id, userId);
		E data = refillToData(resultSet);
		return data;
	}

	protected abstract List<Map<String, Object>> selectOne(int id, String userId);

	/**
	 * @inheritDoc
	 */
	@Override
	public E findByName(String keyword) throws DataAccessException{
		List<Map<String, Object>> resultSet = selectKeyword(keyword);
		E data = refillToData(resultSet);
		return data;
	}

	protected abstract List<Map<String, Object>> selectKeyword(String keyword);

	/**
	 * @inheritDoc
	 */
	@Override
	public E findByUserId(String userId) throws DataAccessException{
		List<Map<String, Object>> resultSet = selectUserId(userId);
		E data = refillToData(resultSet);
		return data;
	}

	protected abstract List<Map<String, Object>> selectUserId(String userId);

	/**
	 * @inheritDoc
	 */
	@Override
	public int save(D d) throws DataAccessException{
		int count = create(d);
		return count;
	}

	protected abstract int create(D d);
}
