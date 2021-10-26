package jp.ac.hcs.gondo.controller.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import jp.ac.hcs.gondo.common.Priority;
import lombok.Data;

@Data
public class TodoForm {

	@NotNull
	@NotBlank
	@Length(min = 1, max = 50)
	private String title;

	private Priority priority;
	
	private String tag;

	@NotNull
	@NotBlank
	@Length(min = 1, max = 1000)
	private String contents;
}
