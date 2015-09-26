package com.codepath.gridimagesearch.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Andre on 9/24/2015.
 */
public class ImageResult implements Serializable{
    private static final long serialVersionUID = 5830626762561424121L;
    public String fullUrl;
    public String thumUrl;
    public String title;


    public ImageResult(JSONObject json){
        try{
            this.fullUrl = json.getString("url");
            this.thumUrl = json.getString("tbUrl");
            this.title = json.getString("title");
        }catch(JSONException e){
            e.printStackTrace();
        }
    }

    public static ArrayList<ImageResult> fromJSONArray(JSONArray array){
        ArrayList<ImageResult> results = new ArrayList<ImageResult>();
            for(int i = 0; i < array.length(); i++)
            {
                try{
                    results.add(new ImageResult(array.getJSONObject(i)));
                }catch(JSONException e){
                    e.printStackTrace();
                }
            }
        return results;
    }


}
