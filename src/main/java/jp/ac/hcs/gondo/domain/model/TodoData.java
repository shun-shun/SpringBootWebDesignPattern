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
	
	// 作成日付
	private Timestamp create_date;
	
	// 更新日付
	private Timestamp update_date;
}
