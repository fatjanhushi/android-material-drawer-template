package com.fatjoni.droid.t25guide;

/**
 * Created by fatjon on 15-05-04.
 */
public class Workout {

    private String name;
    private String description;
    private boolean isChecked;

    public Workout(){

    }

    public Workout(String name, String description){
        this.name = name;
        this.description = description;
    }

    public Workout(String name, String description, boolean isChecked){
        this.name = name;
        this.description = description;
        this.isChecked = isChecked;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setIsChecked(boolean isChecked) {
        this.isChecked = isChecked;
    }
}
