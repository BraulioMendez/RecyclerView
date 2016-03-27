package com.me.recyclerview.volley;

/**
 * Created by Braulio on 26/03/2016.
 */
public class APIRest {

    // Base URL
    private static final String BASE_URL = "http://api.nytimes.com/svc/topstories/v1/business.json?api-key=a35f85751a35df3d0d93a700bf0204fd:9:74583509";

    // GET Methods Urls
    public static String getPostList() {
        return String.format("%s%s", BASE_URL, "post/list");
    }

    // GET Methods with Params
    public static String getPostById(int id) {
        return String.format("%s%s%d", BASE_URL, "post/", id);
    }

}

