package com.me.recyclerview.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Braulio on 26/03/2016.
 */
public class Section {

    @SerializedName("title")
    public String title;
    @SerializedName("section")
    public String section;
    @SerializedName("info")
    public String info;
}
