package jp.ac.hcs.gondo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jp.ac.hcs.gondo.domain.entity.TodoEntity;
import jp.ac.hcs.gondo.domain.service.TopService;

@Controller
public class TopController {

	@Autowired
	TopService topService;

	@RequestMapping("/")
	public String index(Model model) {
		TodoEntity todoEntity = topService.getList();
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
}
