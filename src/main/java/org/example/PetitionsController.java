package org.example;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import	org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PetitionsController {
    @GetMapping("/")
    public String index(){
        return "index";
    }//load index page
    @PostMapping("/index")
    public String returnToIndex() {// return index page on POST
        return "index"; // Return index page on POST
    }


    @GetMapping("/search")
    public String searchPage() {
        return "search";
    }
    @PostMapping("/search")
    public String searchPetition(@RequestParam String petitionName, Model model) {
        // to search patitions TODO: search logic here
        model.addAttribute("result", petitionName);
        return "search";
    }
}
