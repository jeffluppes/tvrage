package com.example.jeff.tvrage.com.example.jeff.tvrage.xmlparser;

import android.util.Log;

import com.example.jeff.tvrage.com.example.jeff.tvrage.xmlparser.feedreaders.FeedReader;
import com.example.jeff.tvrage.com.example.jeff.tvrage.xmlparser.feedreaders.ShowInfoFeedReader;

import org.xmlpull.v1.XmlPullParser;

/**
 * Created by Neutron-PC-Windows on 19-1-2015.
 */
public class XMLParser {
    private volatile boolean isDone = false;
    private XmlPullParser parser;

    public XMLParser(String urlString, FeedReader feedReader) {
        this.fetchXML(urlString, feedReader);
    }

    public void fetchXML(String urlString, FeedReader feedReader){
        Thread thread = new Thread(new XMLParserRunnable(urlString, this, feedReader));
        thread.start();
    }

    public void parseXML(XmlPullParser parser) {
        this.parser = parser;
        this.isDone = true;
    }

    public boolean isDone() {
        return this.isDone;
    }

    public XmlPullParser getData() {
        Log.w("tvrage", "isdone = " + Boolean.toString(isDone));
        return parser;
    }
}
