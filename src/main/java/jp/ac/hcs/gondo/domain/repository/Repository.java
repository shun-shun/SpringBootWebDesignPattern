package jp.ac.hcs.gondo.domain.repository;

import org.springframework.dao.DataAccessException;

public interface Repository <D,E> {

	/**
	 * 全件検索
	 * @return 指定パラメータ型
	 */
	public E findAll() throws DataAccessException;

	/**
	 * ID検索
	 * @param id Int型
	 * @return 指定パラメータ型
	 */
	public E findById(int id, String userId) throws DataAccessException;

	/**
	 * キーワード検索
	 * @param keyword String型
	 * @return 指定パラメータ型
	 */
	public E findByName(String keyword) throws DataAccessException;

	/**
	 * ユーザID検索
	 * @param userId String型
	 * @return 指定パラメータ型
	 */
	public E findByUserId(String userId) throws DataAccessException;

	/**
	 * 作成
	 * @param t 指定パラメータ型
	 * @return 作成件数
	 */
	public int save(D d) throws DataAccessException;
//
//	public int modify(T t);
//
//	public int remove(String id);

}
