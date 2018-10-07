package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GoodsController {
	@GetMapping("/goods/add")
	public String add() {
		return "goods_add";
	}
	@GetMapping("/goods/delete")
	public String delete() {
		return "goods_delete";
	}
	@GetMapping("/goods/list")
	public String list() {
		return "goods_list";
	}

}
