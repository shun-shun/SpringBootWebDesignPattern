package jp.ac.hcs.gondo.domain.service;

public interface Service <T> {

	/** 一覧 */
	T getList();

	/** 取得 */
	T select(String id);
	
	/** 検索 */
	T search(String keyword);

	/** 登録 */
//	int create(T t);

	/** 更新 */
//	int update(T t);

}
