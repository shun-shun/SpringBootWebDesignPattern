package jp.ac.hcs.gondo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.extern.slf4j.Slf4j;

/**
 * 例外に関する機能・画面を制御する.
 */
@Slf4j
@ControllerAdvice
@Component
public class ExceptionControllerAdvice {

	/**
	 * Exception発生をキャッチし、エラー画面を表示する.
	 * @param e エラー情報
	 * @param model
	 * @return エラー画面
	 */
	@ExceptionHandler(Exception.class)
	public String exceptionHandler(Exception e, Model model) {

		log.error("内部サーバーエラー：ExceptionHandler");
		e.printStackTrace();

		model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR);

		return "error";
	}
}