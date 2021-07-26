package jp.ac.hcs.gondo.domain.service;

abstract class ServiceImpl<D,E> implements Service<D,E>{

	@Override
	public E getList() {
		E e = fetch();
		entityDecode(e);
		return e;
	}

	@Override
	public D select(String id, String userId) {
		D d;
		try {
			int i = Integer.parseInt(id);
			d = lookup(i, userId);
			dataDecode(d);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			d = null;
		}
		return d;
	}

	@Override
	public E select(String userId) {
		E e = lookup(userId);
		entityDecode(e);
		return e;
	}

	@Override
	public E search(String keyword) {
		E e = find(keyword);
		entityDecode(e);
		return e;
	}

	@Override
	public int create(D d, String userId) {
		dataEncode(d, userId);
		createProcessing(d);
		int count = add(d);
		return count;
	}

	protected abstract void dataEncode(D d, String userId);

	/** データの取得 */
	protected abstract E fetch();

	/** 画面表示のためのエンコード */
	protected abstract void entityDecode(E e);

	/** 画面表示のためのエンコード */
	protected abstract void dataDecode(D d);

	/** IDでの検索 */
	protected abstract D lookup(int id, String userId);

	/** ユーザIDでの検索 */
	protected abstract E lookup(String userId);

	/** キーワードでの検索 */
	protected abstract E find(String keyword);

	protected abstract int add(D d);

	protected abstract void createProcessing(D d);

}
