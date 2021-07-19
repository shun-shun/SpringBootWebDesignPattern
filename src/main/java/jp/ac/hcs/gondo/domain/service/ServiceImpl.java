package jp.ac.hcs.gondo.domain.service;

abstract class ServiceImpl<T> implements Service<T>{

	@Override
	public T getList() {
		T t = fetch();
		t = encode(t);
		return t;
	}

	/** データの取得 */
	protected abstract T fetch();

	/** 画面表示のためのエンコード */
	protected abstract T encode(T t);

	@Override
	public T select(String id) {
		T t = lookup(id);
		t = encode(t);
		return t;
	}
	
	/** IDでの検索 */
	protected abstract T lookup(String id);
	
	@Override
	public T search(String keyword) {
		T t = find(keyword);
		t = encode(t);
		return t;
	}
	
	/** キーワードでの検索 */
	protected abstract T find(String keyword);
}
