package jp.ac.hcs.gondo.domain.service;

public interface Service <D,E,F> {

	/** 一覧 */
	E getList();

	/** 取得(ID) */
	E select(int id);

	/** 取得(ユーザID) */
	E select(String user_id);

	/** 検索 */
	E search(String keyword);

	/** 登録 */
	int create(F f , String userId);

	/** 更新 */
//	int update(T t);

}
