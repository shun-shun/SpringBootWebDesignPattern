package jp.ac.hcs.gondo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.ac.hcs.gondo.domain.model.ReportEntity;
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
}
