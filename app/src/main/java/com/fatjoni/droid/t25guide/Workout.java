package com.fatjoni.droid.t25guide;

import java.io.Serializable;

/**
 * Created by fatjon on 15-05-04.
 */
public class Workout implements Serializable {

    private String name;
    private boolean isChecked;

    public Workout(){

    }

    public Workout(String name){
        this.name = name;
    }

    public Workout(String name, boolean isChecked){
        this.name = name;
        this.isChecked = isChecked;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setIsChecked(boolean isChecked) {
        this.isChecked = isChecked;
    }

}
