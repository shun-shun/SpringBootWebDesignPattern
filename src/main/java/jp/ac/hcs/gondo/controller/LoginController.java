package jp.ac.hcs.gondo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *  ログインに関する機能・画面を制御する.
 */
@Controller
public class LoginController {

	/**
	 * ログイン画面を表示する.
	 * @param model
	 * @return ログイン画面
	 */
	@GetMapping("/login")
	public String getLogin(Model model) {
		return "login";
	}

	//(SecurityConfig設定前)動作確認用
	//	@PostMapping("/login")
	//	public String postLogin(Model model) {
	//		return "redirect:/";
	//	}
	//	@PostMapping("/logout")
	//	public String postLogout(Principal principal) {
	//		return "redirect:/login";
	//	}

}