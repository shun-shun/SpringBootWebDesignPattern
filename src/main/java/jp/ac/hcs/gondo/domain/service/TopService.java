package jp.ac.hcs.gondo.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.ac.hcs.gondo.domain.entity.TodoEntity;
import jp.ac.hcs.gondo.domain.model.TodoData;
import jp.ac.hcs.gondo.domain.repository.TopRepository;

@Transactional
@Service
public class TopService extends ServiceImpl<TodoEntity>{

	@Autowired
	TopRepository topRepository;

	@Override
	protected TodoEntity fetch() {
		TodoEntity entity = topRepository.findAll();
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
		TodoEntity entity = topRepository.findById(id);
		return entity;
	}
	
	@Override
	protected TodoEntity lookup(String userId) {
		TodoEntity entity = topRepository.findByUserId(userId);
		return entity;
	}

	@Override
	protected TodoEntity find(String keyword) {
		TodoEntity entity = topRepository.findByName(keyword);
		return entity;
	}

}
