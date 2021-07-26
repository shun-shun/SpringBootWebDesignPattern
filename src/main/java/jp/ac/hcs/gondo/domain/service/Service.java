package jp.ac.hcs.gondo.domain.service;

public interface Service <D,E> {

	/** 一覧 */
	E getList();

	/** 取得(ID) */
	D select(String id, String userId);

	/** 取得(ユーザID) */
	E select(String user_id);

	/** 検索 */
	E search(String keyword);

	/** 登録 */
	int create(D d , String userId);

	/** 更新 */
//	int update(T t);

}
