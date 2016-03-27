package com.me.recyclerview.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Braulio on 26/03/2016.
 */
public class SectionCollection {

    @SerializedName("result")
    public List<Section> sections;
}
