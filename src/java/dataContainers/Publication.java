/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataContainers;

/**
 *
 * @author quantap
 */
public class Publication {
    private String publicationTime, publicationText, publicationTitle;
    public Publication(){
        this.publicationText = "Test";
        this.publicationTime = "Test";
        this.publicationTitle = "Test";
    }
    public Publication(String publicationText, String publicationTime, String publicationTitle){
        this.publicationText = publicationText;
        this.publicationTime = publicationTime;
        this.publicationTitle = publicationTitle;
    }
    public String getPublicationText(){
        return this.publicationText;
    }
    public String getPublicationTime(){
        return this.publicationTime;
    }
    public String getPublicationTitle(){
        return this.publicationTitle;
    }
    public boolean setPublicationText(String newPublicationText){
        if(newPublicationText != null){
           this.publicationText = newPublicationText;
           return true;
       }
       return false;
    }
    public boolean setPublicationTitle(String newPublicationTitle){
        if(newPublicationTitle != null){
           this.publicationTitle = newPublicationTitle;
           return true;
       }
       return false;
    }
}
