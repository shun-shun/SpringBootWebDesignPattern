package jp.ac.hcs.gondo.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.ac.hcs.gondo.domain.model.ReportData;
import jp.ac.hcs.gondo.domain.model.ReportEntity;
import jp.ac.hcs.gondo.domain.repository.TopRepository;

@Transactional
@Service
public class TopService extends ServiceImpl<ReportEntity>{

	@Autowired
	TopRepository topRepository;

	@Override
	protected ReportEntity fetch() {
		ReportEntity entity = topRepository.findAll();
		return entity;
	}

	@Override
	protected ReportEntity encode(ReportEntity e) {
		List<ReportData> list = e.getList();
		list.forEach( d -> {
			int applyId = d.getApplyId();
			String userName = d.getClassName();
		});
		return e;
	}


}
