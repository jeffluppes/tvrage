package com.example.jeff.tvrage.com.example.jeff.tvrage.xmlparser;

import android.util.Log;

import com.example.jeff.tvrage.com.example.jeff.tvrage.xmlparser.feedreaders.FeedReader;
import com.example.jeff.tvrage.com.example.jeff.tvrage.xmlparser.feedreaders.ShowInfoFeedReader;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

/**
 * Created by Jeff on 19-1-2015.
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


    /**
    private String readShowName(XmlPullParser parser) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, ns, "name");
        String name = getText(parser);
        parser.require(XmlPullParser.END_TAG, ns, "name");
        return name;
    }

    private String readShowID(XmlPullParser parser) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, ns, "showid");
        String sid = getText(parser);
        parser.require(XmlPullParser.END_TAG, ns, "showid");
        return sid;
    }
     */
}
