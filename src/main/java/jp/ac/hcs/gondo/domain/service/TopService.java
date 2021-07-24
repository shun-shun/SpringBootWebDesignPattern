package jp.ac.hcs.gondo.domain.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.ac.hcs.gondo.controller.form.TodoForm;
import jp.ac.hcs.gondo.domain.entity.TodoEntity;
import jp.ac.hcs.gondo.domain.model.TodoData;
import jp.ac.hcs.gondo.domain.repository.Repository;

@Transactional
@Service
public class TopService extends ServiceImpl<TodoData, TodoEntity, TodoForm>{

	@Autowired
	private Repository<TodoData, TodoEntity> repository;

	@Override
	protected TodoEntity fetch() {
		TodoEntity entity = repository.findAll();
		return entity;
	}

	@Override
	protected TodoEntity encode(TodoEntity e) {
		List<TodoData> list = e.getList();
		list.forEach( d -> {
			int applyId = d.getId();
			String title = d.getTitle();
		});
		return e;
	}

	@Override
	protected TodoEntity lookup(int id) {
		TodoEntity entity = repository.findById(id);
		return entity;
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
	protected TodoData refillToData(TodoForm f, String userId) {
		TodoData data = new TodoData();
		data.setTitle(f.getTitle());
		data.setPriority(f.getPriority());
		data.setContents(f.getContents());
		data.setUser_id(userId);
		return data;
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

}
