package com.nurds.fastfillco.controller;


import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

  /*@RequestMapping("/")
  @ResponseBody
  public String index() {
    return "Proudly handcrafted by " +
        "Robin dhawan";
  }*/

	@RequestMapping("/")
	public String index(Map<String, Object> model) {
		return "welcome";
	}

}
