package com.gfg.lecture1;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
public class SimpleController {

	@ApiOperation("this api will return a string message")
	@GetMapping("/hi")
	public String sayHi() {
		return "hi from spring boot";
	}

	@ApiOperation(value = "returnn result for query parameter", notes = "takes query parameter", response = String.class)
	@GetMapping("/search")
	public String searchApi(@RequestParam String q) {
		return "a good boy";
	}

	@GetMapping("/multisearch")
	public String searchMulti(@RequestParam(required = false) List<String> results) {
		return "results are" + results;
	}

	@GetMapping("/searchword")
	public String searchWord(@RequestParam(defaultValue = "thug") String q) {
		DataStore db = new DataStore();
		return db.getFromDb(q);
	}

}
