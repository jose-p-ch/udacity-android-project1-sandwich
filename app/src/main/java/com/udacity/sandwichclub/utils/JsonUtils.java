package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) throws JSONException {
        JSONObject jSandwich = new JSONObject(json);
        JSONObject jSandwichName = jSandwich.getJSONObject("name");
        String mainName = jSandwichName.optString("mainName");
        ArrayList<String> alsoKnownAs = new ArrayList<String>();
        JSONArray jAlsoKnownAs = jSandwichName.getJSONArray("alsoKnownAs");
        jsonArrayToList(alsoKnownAs, jAlsoKnownAs);
        String placeOfOrigin = jSandwich.optString("placeOfOrigin");
        String description = jSandwich.optString("description");
        String image = jSandwich.optString("image");
        ArrayList<String> ingredients = new ArrayList<String>();
        JSONArray jIngredients = jSandwich.getJSONArray("ingredients");
        jsonArrayToList(ingredients, jIngredients);
        Sandwich sandwich = new Sandwich(mainName, alsoKnownAs, placeOfOrigin, description, image, ingredients);
        return sandwich;
    }

    public static void jsonArrayToList(List<String> list, JSONArray array) {
        if (array != null) {
            if(array.length() == 0){
                return;
            }
            for (int i = 0; i < array.length(); i++) {
                list.add(array.optString(i));
            }
        }
        return;
    }
}
