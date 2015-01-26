package com.example.jeff.tvrage.com.example.jeff.tvrage.xmlparser;

import android.os.AsyncTask;
import android.util.Log;

import com.example.jeff.tvrage.com.example.jeff.tvrage.objects.Show;
import com.example.jeff.tvrage.com.example.jeff.tvrage.xmlparser.feedreaders.FeedReader;
import com.example.jeff.tvrage.com.example.jeff.tvrage.xmlparser.feedreaders.ShowInfoFeedReader;
import org.springframework.http.converter.xml.SimpleXmlHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import org.xmlpull.v1.XmlPullParser;

/**
 * Created by Jeff on 19-1-2015.
 */
public class ShowInfoParserAsync extends AsyncTask<String, Void, Show> {
    private volatile boolean isDone = false;

    @Override
    public Show doInBackground(String[] url) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new SimpleXmlHttpMessageConverter());
        Show show = restTemplate.getForObject(url[0], Show.class);
        Log.w("tvrage", "done with parsing, show's name was: "+ show.getName());
        return show;
    }
}