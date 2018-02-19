package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {




        try {

            JSONObject jsonObject = new JSONObject(json);
            JSONObject objectName = jsonObject.getJSONObject("name");

            String sandwichName = objectName.getString("mainName");

            JSONArray alsoKnownAsJsonArray = jsonObject.getJSONArray("alsoKnownAs");
            List<String> alsoKnownAs = new ArrayList<>();
            for(int i=0; i<alsoKnownAsJsonArray.length(); i++) {
                alsoKnownAs.add(alsoKnownAsJsonArray.getString(i));
            }

            String origin = "";
            if(objectName.has("placeOfOrigin")) {
                origin = objectName.getString("placeOfOrigin");
            }

            String description = objectName.getString("description");

            String imagePath = objectName.getString("image");

            JSONArray ingredientsArray = objectName.getJSONArray("ingredients");
            List<String> ingredients = new ArrayList<>();
            for(int i=0; i<ingredientsArray.length(); i++) {
                ingredients.add(ingredientsArray.getString(i));
            }

            Sandwich sandwich = new Sandwich(sandwichName, alsoKnownAs, origin, description,
                    imagePath, ingredients);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }
}
