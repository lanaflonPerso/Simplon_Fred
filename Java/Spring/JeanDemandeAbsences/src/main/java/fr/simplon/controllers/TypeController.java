package fr.simplon.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TypeController {

	@RequestMapping("/type")
    public String index() {
        return "type";
    }

}
