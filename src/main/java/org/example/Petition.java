package org.example;

public class Petition {
    //initialise & store variables
    private String petitionCreationId;
    private String petitionUserName;
    private String userEmail;
    //Constructor for creating a new Petition object
    public Petition(String petitionCreationId, String petitionUserName, String userEmail) {
        this.petitionCreationId = petitionCreationId;
        this.petitionUserName = petitionUserName;
        this.userEmail = userEmail;
    }

    //read in Petition entered values
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
