package com.example.jeff.tvrage.com.example.jeff.tvrage.xmlparser;

import android.util.Log;

import com.example.jeff.tvrage.com.example.jeff.tvrage.xmlparser.feedreaders.FeedReader;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Neutron-PC-Windows on 19-1-2015.
 */
public class XMLParserRunnable implements Runnable {

    String url = "";
    XMLParser xmlparser;
    FeedReader feedreader;

    public XMLParserRunnable(String url, XMLParser xmlparser, FeedReader feedreader) {
        this.url = url;
        this.xmlparser = xmlparser;
        this.feedreader = feedreader;
    }

    private String getUrl() {
        return this.url;
    }

    @Override
    public void run() {

        try {
            if (url == null)
                url = "";

            Log.w("tvrage", "url of parse" + url);

            URL url = new URL(this.getUrl());
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(10000 /* milliseconds */);
            conn.setConnectTimeout(15000 /* milliseconds */);
            conn.setRequestMethod("GET");
            conn.setDoInput(true);
            conn.connect();
            InputStream stream = conn.getInputStream();

            XmlPullParserFactory xmlFactoryObject = XmlPullParserFactory.newInstance();
            XmlPullParser myparser = xmlFactoryObject.newPullParser();

            myparser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            myparser.setInput(stream, null);
            feedreader.readFeed(myparser);
            stream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
