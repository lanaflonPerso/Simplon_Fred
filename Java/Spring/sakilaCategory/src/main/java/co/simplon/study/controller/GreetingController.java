package co.simplon.study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.study.domain.Greeting;
import co.simplon.study.service.GreetingService;

@RestController
public class GreetingController {

	@Autowired
	GreetingService greetingService;
    
    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return greetingService.getGreetingMessage(name);
    }
}
