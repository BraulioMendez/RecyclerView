package com.me.recyclerview.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Braulio on 27/03/2016.
 */
public class SectionCollection {

    @SerializedName("results")

    public List<Section> sections;
}
