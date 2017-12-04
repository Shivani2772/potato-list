package com.potatolist;

import java.io.Serializable;

/**
 * Created by t00062765 on 12/3/2017.
 */

public class Potato implements Serializable{
    private String name, icon, description;

    public Potato(String name, String icon, String description) {
        this.name = name;
        this.icon = icon;
        this.description = description;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getIcon() {

        switch (icon){
            case "kerrs_pink":
                return R.drawable.kerrs_pink;
            case "dore":
                return R.drawable.dore;
            case "duke_of_york":
                return R.drawable.duke_of_york;

            default:
                return 0;
        }
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
