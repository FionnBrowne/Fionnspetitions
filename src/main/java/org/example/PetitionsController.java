package org.example;
import org.springframework.stereotype.Controller;
import	org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PetitionsController {
    @GetMapping("/")
    public String index(){
        return "index";
    }

}
