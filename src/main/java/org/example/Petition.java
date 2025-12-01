package org.example;

import java.util.ArrayList;
import java.util.List;

public class Petition {
    //initialise & store variables
    private String petitionCreationId;
    private String petitionUserName;
    private String userEmail;
// List of signatures added by users
    private List<String> signatures = new ArrayList<>();

    //Constructor for creating a new Petition object
    public Petition(String petitionCreationId, String petitionUserName, String userEmail) {
        this.petitionCreationId = petitionCreationId;
        this.petitionUserName = petitionUserName;
        this.userEmail = userEmail;
    }

    //add a new signature to tje signature list
    public void addSignature(String name, String email) {
        signatures.add(name + " (" + email + ")");
    }
    //Return the list
    public List<String> getSignatures() {
        return signatures;
    }

    //read in Petition entered values for Thymeleaf
    public String getPetitionCreationId() {
        return petitionCreationId;
    }
    public String getPetitionUserName() {
        return petitionUserName;
    }
    public String getUserEmail() {
        return userEmail;
    }
}
