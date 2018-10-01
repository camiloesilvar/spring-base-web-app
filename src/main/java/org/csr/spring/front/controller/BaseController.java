package org.csr.spring.front.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class BaseController {

	@GetMapping("/base")
	public String inicio(ModelMap model) {
		return "base";
	}
}
