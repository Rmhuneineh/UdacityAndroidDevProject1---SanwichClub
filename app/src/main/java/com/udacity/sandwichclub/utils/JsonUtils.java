package com.udacity.sandwichclub.utils;

import android.util.Log;

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

            JSONArray alsoKnownAsJsonArray = objectName.getJSONArray("alsoKnownAs");
            List<String> alsoKnownAs = new ArrayList<>();
            for(int i=0; i<alsoKnownAsJsonArray.length(); i++) {
                alsoKnownAs.add(alsoKnownAsJsonArray.getString(i));
            }

            String origin = "";
            if(jsonObject.has("placeOfOrigin")) {
                origin = jsonObject.getString("placeOfOrigin");
            }

            String description = jsonObject.getString("description");

            String imagePath = jsonObject.getString("image");

            JSONArray ingredientsArray = jsonObject.getJSONArray("ingredients");
            List<String> ingredients = new ArrayList<>();
            for(int i=0; i<ingredientsArray.length(); i++) {
                ingredients.add(ingredientsArray.getString(i));
            }

            Log.v("JsonUtils", "Sandwich name: " + sandwichName +
                    " \nAlso known as: " + alsoKnownAs + " \nOrigin: " + origin +
                    " \nDescription: " + description + " \nImage path: " + imagePath +
                    " \nIngredients: " + ingredients);

            Sandwich sandwich = new Sandwich(sandwichName, alsoKnownAs, origin, description,
                    imagePath, ingredients);

            return sandwich;

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }
}
