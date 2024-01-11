package dataContainers;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author quantap
 */
public class ResourceInfo {
    private String title , link;
    public ResourceInfo(String title, String link){
        this.title= title;
        this.link = link;
    }
    public boolean setTitle(String title){
        if(title != null){
            this.title = title;
            return true;
        }else return false;
    }
    public boolean setLink(String link){
        if(link != null){
            this.link = link;
            return true;
        }else return false;
        
    }
    public String getTitle(){
        return this.title;
    }
    public String getLink(){
        return this.link;
    }
}
