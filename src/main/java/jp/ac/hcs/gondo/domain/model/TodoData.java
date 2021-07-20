package jp.ac.hcs.gondo.domain.model;

import java.sql.Timestamp;

import jp.ac.hcs.gondo.common.Priority;
import lombok.Data;

@Data
public class TodoData {
	
	// ID
	private int id;

	// タイトル
	private String title;
	
	// 優先度
	private Priority priority;
	
	// 内容
	private String contents;
	
	// ユーザID
	private String user_id;
	
	// タイムスタンプ
	private Timestamp create_date;
}
