package jp.ac.hcs.gondo.domain.service;

abstract class ServiceImpl<D,E,F> implements Service<D,E,F>{

	@Override
	public E getList() {
		E e = fetch();
		e = encode(e);
		return e;
	}

	/** データの取得 */
	protected abstract E fetch();

	/** 画面表示のためのエンコード */
	protected abstract E encode(E e);

	@Override
	public E select(int id) {
		E e = lookup(id);
		e = encode(e);
		return e;
	}

	/** IDでの検索 */
	protected abstract E lookup(int id);

	@Override
	public E select(String userId) {
		E e = lookup(userId);
		e = encode(e);
		return e;
	}


	/** ユーザIDでの検索 */
	protected abstract E lookup(String userId);

	@Override
	public E search(String keyword) {
		E e = find(keyword);
		e = encode(e);
		return e;
	}

	/** キーワードでの検索 */
	protected abstract E find(String keyword);

	@Override
	public int create(F f, String userId) {
		D d = refillToData(f, userId);
		createProcessing(d);
		int count = add(d);
		return count;
	}

	protected abstract D refillToData(F f, String userId);

	protected abstract int add(D d);

	protected abstract void createProcessing(D d);
}
