package com.gfg.lecture1;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {

	
	@GetMapping("/hi")
	public String sayHi() {
		return "hi from spring boot";
	}
	@GetMapping("/search")
		public String searchApi(@RequestParam String q) {
			return "a good boy";
		}
	@GetMapping("/multisearch")
		public String searchMulti(@RequestParam(required = false) List<String>results) {
			return "results are"+results;
		}
	@GetMapping("/searchword")
	public String searchWord(@RequestParam(defaultValue = "thug") String q) {
		DataStore db=new DataStore();
		return db.getFromDb(q);
	}
	
}
