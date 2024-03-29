package jp.ac.hcs.gondo.controller;

import java.security.Principal;

import javax.validation.constraints.Pattern;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jp.ac.hcs.gondo.common.Priority;
import jp.ac.hcs.gondo.controller.form.TodoForm;
import jp.ac.hcs.gondo.domain.entity.TodoEntity;
import jp.ac.hcs.gondo.domain.model.TodoData;
import jp.ac.hcs.gondo.domain.service.Service;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class TopController {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private Service<TodoData, TodoEntity> service;

	@RequestMapping("/")
	public String index(Principal principal, Model model) {
		TodoEntity todoEntity = service.select(principal.getName());
		log.info("[ユーザID]:" + principal.getName() + " データ: " + todoEntity);
		model.addAttribute("todoEntity", todoEntity);
		return "index";
	}

	@RequestMapping("/search")
	public String search(@RequestParam("keyword") String keyword, Principal principal, Model model) {
		if (keyword == null || keyword.isBlank()) {
			return index(principal, model);
		}
		TodoEntity todoEntity = service.search(keyword);
		log.info("[ユーザID]:" + principal.getName() + " データ: " + todoEntity);
		model.addAttribute("todoEntity", todoEntity);
		return "index";
	}

	@RequestMapping("/lookup")
	public String lookup(@RequestParam("id") String id, Principal principal, Model model) {
		TodoEntity todoEntity = service.select(id);
		log.info("[ユーザID]:" + principal.getName() + " データ: " + todoEntity);
		model.addAttribute("todoEntity", todoEntity);
		return "index";
	}

	@RequestMapping(path = "/create", method = RequestMethod.GET)
	public String input(@ModelAttribute TodoForm form, Principal principal, Model model) {
		log.info("[ユーザID]:" + principal.getName());
		model.addAttribute("priorityList", Priority.values());
		return "input";
	}

	@RequestMapping(path = "/create", method = RequestMethod.POST)
	public String create(@ModelAttribute @Validated TodoForm form, BindingResult bindingResult, Principal principal,
			Model model) {
		if (bindingResult.hasErrors()) {
			return input(form, principal, model);
		}
		TodoData todoData = modelMapper.map(form, TodoData.class);
		todoData.setPriority(Priority.valueOf(form.getPriority()));
		todoData.setTags(form.getTag());
		int count = service.create(todoData, principal.getName());
		if (count > 0) {
			return index(principal, model);
		}
		return input(form, principal, model);
	}

	@RequestMapping(path = "/detail", method = RequestMethod.GET)
	public String detail(@RequestParam("id") @Validated @Pattern(regexp = "^[0-9]+$") String id, Principal principal,
			Model model) {
		log.info("[ユーザID]:" + principal.getName());
		TodoData todoData = service.select(id, principal.getName());
		model.addAttribute("todoData", todoData);
		return "detail";
	}
}
