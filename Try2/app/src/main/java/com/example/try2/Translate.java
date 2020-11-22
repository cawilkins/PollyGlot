package com.example.try2;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;


//used in Main Activity
public class Translate {
    //does actual request
    private static String Post(String intext) throws IOException {
        String apikey = "6636ac7838bb4b71a89d01e5e1dd0ede";
        String myurl = "https://api.cognitive.microsofttranslator.com/translate?api-version=3.0&to=fa";
        OkHttpClient client = new OkHttpClient();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "[{\n\t\"Text\": \"" + intext +"\"\n}]");
        Request request = new Request.Builder()
                .url(myurl).post(body)
                .addHeader("Ocp-Apim-Subscription-Key", apikey)
                .addHeader("Ocp-Apim-Subscription-Region", "eastus")
                .addHeader("Content-type", "application/json").build();
        Response text = client.newCall(request).execute();
        return text.body().string();
    }

    //changes response of api to text instead of json
    private static String toText(String jsontxt) throws JSONException{
        JSONObject jsonObject = new JSONArray(jsontxt).getJSONObject(0).getJSONArray("Translations").getJSONObject(0);
        return jsonObject.getString("text");
    }

    public static String doTranslation(String inputtext) throws JSONException, IOException {
        String resp = "Unable to translate";
        resp = toText(Post(inputtext));
        return resp;
    }
}


