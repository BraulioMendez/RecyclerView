package com.me.recyclerview.util;

import android.util.Log;

import com.google.gson.Gson;
import com.me.recyclerview.model.SectionCollection;

import org.json.JSONObject;

/**
 * Created by Braulio on 26/03/2016.
 */
public class NewGenerator {

    public  static SectionCollection getSectionCollection (JSONObject jsonObject){
        Gson gson = new Gson();
        SectionCollection seccionCollection = gson.fromJson(jsonObject.toString(), SectionCollection.class);
        Log.i("NewGenerator", "size: " + seccionCollection.sections.size());
        return seccionCollection;
    }
}
