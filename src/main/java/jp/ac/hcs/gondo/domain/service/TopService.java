package jp.ac.hcs.gondo.domain.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.ac.hcs.gondo.domain.entity.TodoEntity;
import jp.ac.hcs.gondo.domain.model.TodoData;
import jp.ac.hcs.gondo.domain.repository.Repository;

@Transactional
@Service
public class TopService extends ServiceImpl<TodoData, TodoEntity> {

	@Autowired
	private Repository<TodoData, TodoEntity> repository;

	@Override
	protected TodoEntity fetch() {
		TodoEntity entity = repository.findAll();
		return entity;
	}

	@Override
	protected void entityDecode(TodoEntity e) {
		List<TodoData> list = e.getList();
		for (TodoData d : list) {
			dataDecode(d);
		}
	}

	@Override
	protected void dataDecode(TodoData d) {
		int applyId = d.getId();
		String title = d.getTitle();
	}

	@Override
	protected TodoData lookup(int id, String userId) {
		TodoEntity entity = repository.findById(id, userId);
		if (entity.getList().size() < 1) {
			TodoData data = null;
			return data;
		}
		TodoData data = entity.getList().get(0);
		return data;
	}

	@Override
	protected TodoEntity lookup(String userId) {
		TodoEntity entity = repository.findByUserId(userId);
		return entity;
	}

	@Override
	protected TodoEntity find(String keyword) {
		TodoEntity entity = repository.findByName(keyword);
		return entity;
	}

	@Override
	protected int add(TodoData d) {
		int count = repository.save(d);
		return count;
	}

	@Override
	protected void createProcessing(TodoData d) {
		d.setCreate_date(new Timestamp(System.currentTimeMillis()));
	}

	@Override
	protected void dataEncode(TodoData d, String userId) {
		d.setUser_id(userId);
		Timestamp now = new Timestamp(System.currentTimeMillis());
		d.setUpdate_date(now);
		d.setCreate_date(now);
	}

}
