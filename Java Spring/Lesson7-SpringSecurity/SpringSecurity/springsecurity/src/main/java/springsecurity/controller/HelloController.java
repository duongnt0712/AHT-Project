package springsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
	
	@GetMapping("/helloWorld")
	public String helloWorld() {
		return "hello-world";
	}
	
	@ResponseBody
	@GetMapping("/hello")
	public String hello() {
		return "Hello from url /hello";
	}
	
	@ResponseBody
	@GetMapping("/bye")
	public String bye() {
		return "Hello from url /bye";
	}
}
