package org.example;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import	org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PetitionsController {

    // Store petitions in memory
    private List<Petition> petitions = new ArrayList<>();

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

    @GetMapping("/createPetitions")
    public String createPetitionsPage() {
        return "createPetitions";
    }

    // HANDLE the form submission
    @PostMapping("/createPetitions")
    public String createPetition(@RequestParam String petitionCreationId ,
                                 @RequestParam String petitionUserName ,
                                 @RequestParam String userEmail,
                                 Model model) {

        Petition p = new Petition(petitionCreationId , petitionUserName , userEmail );
        petitions.add(p);

        model.addAttribute("message", "Petition successfully created!");
        return "createPetitions"; // reload page with success message
    }

//view all petitions
    @GetMapping("/viewPetitions")
    public String viewPetitionsPage(Model model) {
        model.addAttribute("petitions", petitions);//send list tp html page
        return "viewPetitions";
    }
    @GetMapping("/searchDisplay")
    public String searchDisplayPage() {
        return "searchDisplay";
    }
}
