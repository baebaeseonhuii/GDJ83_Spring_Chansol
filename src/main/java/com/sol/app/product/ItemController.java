package com.sol.app.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/product/")
public class ItemController {
	@Autowired
	private ItemService itemService;
	
	@RequestMapping("list")
	public void getList(Model model) throws Exception {
		List<ItemDTO> list = itemService.getList();
		model.addAttribute("list", list);
	}
	
	@RequestMapping("detail")
	public void getDetail(Model model, Long id) throws Exception {
		ItemDTO dto = itemService.getDetail(id);
		model.addAttribute("dto", dto);
	}
	
	@RequestMapping(value="add", method=RequestMethod.GET)
	public void add() {	}
	
	@RequestMapping(value="add", method=RequestMethod.POST)
	public String add(ItemDTO dto) throws Exception {
		itemService.add(dto);
		return "redirect:./list";
	}
}
