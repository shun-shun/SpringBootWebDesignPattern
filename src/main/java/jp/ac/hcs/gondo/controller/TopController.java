package jp.ac.hcs.gondo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jp.ac.hcs.gondo.domain.entity.ReportEntity;
import jp.ac.hcs.gondo.domain.service.TopService;

@Controller
public class TopController {

	@Autowired
	TopService topService;

	@RequestMapping("/")
	public String index(Model model) {
		ReportEntity reportEntity = topService.getList();
		model.addAttribute("reportEntity", reportEntity);
		return "index";
	}
	
	@RequestMapping("/search")
	public String search(@RequestParam("keyword") String keyword, Model model) {
		ReportEntity reportEntity = topService.search(keyword);
		model.addAttribute("reportEntity", reportEntity);
		return "index";
	}
	
	@RequestMapping("/lookup")
	public String lookup(@RequestParam("id") String id, Model model) {
		ReportEntity reportEntity = topService.select(id);
		model.addAttribute("reportEntity", reportEntity);
		return "index";
	}
}
