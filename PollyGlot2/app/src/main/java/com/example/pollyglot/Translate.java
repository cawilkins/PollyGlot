package com.example.pollyglot;

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

//referenced https://github.com/dvento/MSazureApi_test/blob/master/app/src/main/java/com/searchbar/msazureapi_test/MStranslate.java
//for help with setting up api
//used in Dictionary

public class Translate {
    //does request
    private static String Post(String intext) throws IOException {
        //values to be used
        String apikey = "6636ac7838bb4b71a89d01e5e1dd0ede";
        String myurl = "https://api.cognitive.microsofttranslator.com/translate?api-version=3.0&to=fa";
        //set up client
        OkHttpClient client = new OkHttpClient();
        //will return json
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "[{\n\t\"Text\": \"" + intext +"\"\n}]");
        //do headers
        Request request = new Request.Builder()
                .url(myurl).post(body)
                .addHeader("Ocp-Apim-Subscription-Key", apikey)
                .addHeader("Ocp-Apim-Subscription-Region", "eastus")
                .addHeader("Content-type", "application/json").build();
        //actual request
        Response text = client.newCall(request).execute();
        return text.body().string();
    }

    //gets rid of excess json notation in string
    private static String toText(String jsontxt) throws JSONException{
        String text = jsontxt.substring(76, jsontxt.length()-15);
        return text;
    }

    //used in directly Dictionary
    public static String doTranslation(String inputtext) throws IOException, JSONException {
        String resp;
        resp = toText(Post(inputtext));
        return resp;
    }
}
