package jp.ac.hcs.gondo.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jp.ac.hcs.gondo.controller.form.TodoForm;
import jp.ac.hcs.gondo.domain.entity.TodoEntity;
import jp.ac.hcs.gondo.domain.service.TopService;

@Controller
public class TopController {

	@Autowired
	TopService topService;

	@RequestMapping("/")
	public String index(Principal principal, Model model) {
		TodoEntity todoEntity = topService.select(principal.getName());
		model.addAttribute("todoEntity", todoEntity);
		return "index";
	}

	@RequestMapping("/search")
	public String search(@RequestParam("keyword") String keyword, Model model) {
		TodoEntity todoEntity = topService.search(keyword);
		model.addAttribute("todoEntity", todoEntity);
		return "index";
	}

	@RequestMapping("/lookup")
	public String lookup(@RequestParam("id") String id, Model model) {
		TodoEntity todoEntity = topService.select(id);
		model.addAttribute("todoEntity", todoEntity);
		return "index";
	}

	public String input(@ModelAttribute TodoForm form, Model model) {
		return "input";
	}

	@RequestMapping(path = "/create", method = RequestMethod.POST)
	public String create(@ModelAttribute @Validated TodoForm form, Model model) {
		int count = topService.create(form);
		if (count > 0) {
			return "index";
		}
		return input(form, model);
	}
}
