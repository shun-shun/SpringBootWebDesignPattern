package jp.ac.hcs.gondo.domain.entity;

import java.util.ArrayList;
import java.util.List;

import jp.ac.hcs.gondo.domain.model.TodoData;
import lombok.Data;

@Data
public class TodoEntity {
	
	private List<TodoData> list = new ArrayList<TodoData>();
}