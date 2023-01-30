package jp.ac.hcs.gondo.controller.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Data
public class TodoForm {

	/**
	 * やること(1文字～50文字)
	 */
	@NotNull
	@NotBlank
	@Length(min = 1, max = 50)
	private String title;

	/**
	 * 優先度
	 */
	@Pattern(regexp = "^(HIGH|MIDDLE|LOW)$")
	private String priority;
	
	/**
	 * タグ
	 */
	@NotNull
	private String tag;

	/**
	 * メモ(1文字～1000文字)
	 */
	@NotNull
	@NotBlank
	@Length(min = 1, max = 1000)
	private String contents;
}
