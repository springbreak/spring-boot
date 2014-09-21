package lambda.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@EnableAutoConfiguration
public class HomeController {

	
	@RequestMapping(value = "/greeting/{id}", method = RequestMethod.GET)
	@ResponseBody
	String greeting(
			@PathVariable(value="id") int id,
			@RequestParam(value="name", required=false, defaultValue="user") String name) {
	
		return name + "'s id : " + id;
	}
}
