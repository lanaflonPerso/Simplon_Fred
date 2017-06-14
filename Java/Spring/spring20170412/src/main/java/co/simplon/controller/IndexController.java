package co.simplon.controller;

import javax.annotation.Resource;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/error")
public class IndexController {

	@Resource
	private String sortie;
	
//    private final Logger logger = LoggerFactory.getLogger(IndexController.class);

    public String index() {
    	
        return "Coucou";
    }

}