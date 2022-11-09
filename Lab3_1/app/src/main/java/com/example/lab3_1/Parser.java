package com.example.lab3_1;

import static android.provider.ContactsContract.CommonDataKinds.Website.URL;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.Volley;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Parser {

    static class DownloadContentTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... strings) {
            java.net.URL url = null;
            HttpURLConnection urlConnection = null;
            StringBuilder result = new StringBuilder();
            try {
                url = new URL(strings[0]);
                urlConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = urlConnection.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader reader = new BufferedReader(inputStreamReader);
                String line = reader.readLine();
                while (line != null) {
                    result.append(line);
                    line = reader.readLine();
                }
                return result.toString();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (urlConnection != null)
                    urlConnection.disconnect();
            }
            return null;
        }
    }

    public static void getContent(ArrayList<String> names, ArrayList<String> urls, String url)
    {
        DownloadContentTask task = new DownloadContentTask();
        try {
            String content = task.execute(url).get();
            String start = "<div class=\"models_list row\">";
            String finish = "<div class=\"col-md-3 col-sm-4 main-col-right\">";
            Pattern pattern = Pattern.compile(start+ "(.*?)"+ finish);
            Matcher matcher = pattern.matcher(content);
            String splitContent = "";
            while (matcher.find())
                splitContent = matcher.group(1);

            Pattern paternImg = Pattern.compile(" <span class=\"ico_box\">                                <img src=\"(.*?)\" class=\"icon\"");
            Pattern patternName = Pattern.compile("<span class=\"name\">(.*?)</span>");
            Matcher matcherImg = paternImg.matcher(splitContent);
            Matcher matcherName = patternName.matcher(splitContent);
            while (matcherImg.find())
                urls.add(matcherImg.group(1));
            while (matcherName.find())
                names.add(matcherName.group(1));
            //for (String s:urls)
            //     Log.i("MyResult", s);


        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
