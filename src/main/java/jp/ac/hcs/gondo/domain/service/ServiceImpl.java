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


}
