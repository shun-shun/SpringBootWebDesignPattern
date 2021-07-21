package jp.ac.hcs.gondo.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import jp.ac.hcs.gondo.common.Priority;
import lombok.Data;

@Data
public class TodoForm {

	@NotNull
	@NotEmpty
	private String title;
	
	private Priority priority;
	
	@NotNull
	@NotEmpty
	private String contents;
	
	@NotNull
	@NotEmpty
	private String user_id;
	
}
