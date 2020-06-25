package com.example.pro5.besttourapp;

import java.io.Serializable;

public class ListItem implements Serializable {
    private String Mname;
    private int imageID;
    private String description;
    private String locationGeo;

    public String getLocationGeo() {
        return locationGeo;
    }

    public void setLocationGeo(String locationGeo) {
        this.locationGeo = locationGeo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ListItem(String airport_info, int image, int description, String locationGeo){

    }

    public ListItem(String name, int imageID, String description, String locationGeo) {
        this.Mname = name;
        this.imageID = imageID;
        this.description = description;
        this.locationGeo = locationGeo;
    }

    public String getName() {

        return Mname;
    }

    public void setName(String name) {
        this.Mname = name;
    }

    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }
}
