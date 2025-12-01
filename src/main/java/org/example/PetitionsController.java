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
    //Populating sample petitions for project
    public PetitionsController() {
        petitions.add(new Petition("SaveTheForests", "Emma Green", "emma.green@example.com"));
        petitions.add(new Petition("FreeSchoolLunches", "Mark Thompson", "mark.thompson@example.com"));
        petitions.add(new Petition("CleanTheOceans", "Lily Waters", "lily.waters@example.com"));
    }
    //landing page
    @GetMapping("/")
    public String index(){
        return "index";
    }//load index page
    @PostMapping("/index")
    public String returnToIndex() {// return index page on POST
        return "index"; // Return index page on POST
    }

    //search petition page
    @GetMapping("/search")
    public String searchPage() {
        return "search";
    }
    @PostMapping("/search")
    public String searchPetition(@RequestParam String searchId, Model model) {
        //for loop to itterate through the list until it finds a match or none are foumd
        for (Petition p : petitions) {
            if (p.getPetitionCreationId().equalsIgnoreCase(searchId)) {
                //TRUE -> display page
                model.addAttribute("petition", p);
                return "searchDisplay";   // show petition result
            }
        }
        //no match found
        model.addAttribute("error", "No Petition with this ID was found.");
        return "search";
    }

    @GetMapping("/sign")
    public String signPetitionForm(@RequestParam String id, Model model) {
        //Find the petition entered
        for (Petition p : petitions) {
            if (p.getPetitionCreationId().equalsIgnoreCase(id)) {
                model.addAttribute("petition", p);
                return "signPetition";
            }
        }

        model.addAttribute("error", "Petition not found.");
        return "search";
    }

    @PostMapping("/sign")
    public String signPetition(@RequestParam String id,
                               @RequestParam String signerName,
                               @RequestParam String signerEmail,
                               Model model) {
        //find correct petition
        for (Petition p : petitions) {
            if (p.getPetitionCreationId().equalsIgnoreCase(id)) {
                //add signature
                p.addSignature(signerName, signerEmail);
                //reload page
                model.addAttribute("petition", p);
                model.addAttribute("message", "Thank you for signing & joining the cause!");
                return "searchDisplay";
            }
        }

        model.addAttribute("error", "Petition not found.");
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
