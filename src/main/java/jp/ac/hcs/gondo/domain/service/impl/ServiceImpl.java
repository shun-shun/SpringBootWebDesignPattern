package jp.ac.hcs.gondo.domain.service.impl;

import jp.ac.hcs.gondo.domain.service.Service;

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

	abstract void dataEncode(D d, String userId);

	/** データの取得 */
	abstract E fetch();

	/** 画面表示のためのエンコード */
	abstract void entityDecode(E e);

	/** 画面表示のためのエンコード */
	abstract void dataDecode(D d);

	/** IDでの検索 */
	abstract D lookup(int id, String userId);

	/** ユーザIDでの検索 */
	abstract E lookup(String userId);

	/** キーワードでの検索 */
	abstract E find(String keyword);

	abstract int add(D d);

	abstract void createProcessing(D d);

}
