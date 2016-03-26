package com.me.recyclerview.volley;

/**
 * Created by Braulio on 26/03/2016.
 */
public class APIRest {

    // Base URL
    private static final String BASE_URL = "";

    // GET Methods Urls
    public static String getPostList() {
        return String.format("%s%s", BASE_URL, "post/list");
    }

    // GET Methods with Params
    public static String getPostById(int id) {
        return String.format("%s%s%d", BASE_URL, "post/", id);
    }

}

