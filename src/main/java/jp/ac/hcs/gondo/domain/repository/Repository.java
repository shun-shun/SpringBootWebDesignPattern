package jp.ac.hcs.gondo.domain.repository;

public interface Repository <T> {
	
	public T findAll();
	
	public T findById(String id);
	
	public T findByName(String keyword);
	
//	public int save(T t);
//	
//	public int modify(T t);
//	
//	public int remove(String id);

}
