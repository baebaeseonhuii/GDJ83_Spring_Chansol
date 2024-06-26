package com.sol.app.locations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
}
