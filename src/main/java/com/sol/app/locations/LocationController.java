package com.sol.app.locations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sol.app.departments.DepartmentDTO;

@Controller
@RequestMapping("/location/*")
public class LocationController {

	@Autowired
	private LocationService locationService;

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public void getList(Model model) throws Exception {
		List<LocationDTO> list = locationService.getList();
		model.addAttribute("list", list);
	}

	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public String getDetatil(Model model, Integer location_id) throws Exception {
		LocationDTO locationDTO = locationService.getDetail(location_id);

		String path = "/commons/message";

		if (locationDTO != null) {
			model.addAttribute("dto", locationDTO);
			path = "/location/detail";

		} else {
			model.addAttribute("result", "지역을 찾을 수 없습니다");
			model.addAttribute("url", "./list");

		}

		return path;

	}

	@RequestMapping(value = "add", method = RequestMethod.GET)
	public void add() throws Exception {

	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(Model model, LocationDTO locationDTO) throws Exception {
		int result = locationService.add(locationDTO);
		
		String url = "";
		if(result > 0) {
			url="redirect:./list";
			
		}else {
			url = "/commons/messages";
			model.addAttribute("url", "./list");
			model.addAttribute("result", "지역 등록 실패");
			
		}
		
		return url;
			
	}
	
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String delete(Model model, LocationDTO locationDTO) throws Exception {
		int result = locationService.delete(locationDTO);

		String url = "";

		if (result > 0) {
			url = "redirect:./list";
			
		} else {
			url = "/commons/message";
			model.addAttribute("result", "부서 삭제 실패");
			model.addAttribute("url", "./list");
			
		}
		
		return url;
	}
	
	@RequestMapping(value="update", method=RequestMethod.GET)
	public String update(Model model ,Integer location_id) throws Exception {
		LocationDTO locationDTO = locationService.getDetail(location_id);
		
		String url = "";
		
		if(locationDTO != null) {
			url = "/location/update";
			model.addAttribute("dto", locationDTO);
			
		} else {
			url = "/commons/message";
			model.addAttribute("result", "존재하지 않는 부서입니다");
			model.addAttribute("url", "./list");
			
		}
		
		return url;
		
	}
	
	@RequestMapping(value="update", method=RequestMethod.POST)
	public String update(Model model, LocationDTO locationDTO) throws Exception {
		int result = locationService.update(locationDTO);
		
		String url = "";
		
		if(result > 0) {
			url="redirect:./list";
			
		} else {
			url = "/commons/message";
			model.addAttribute("result", "부서 수정 실패");
			model.addAttribute("url", "./list");
			
		}
		
		return url;
	}
}
