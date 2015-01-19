package com.example.jeff.tvrage.com.example.jeff.tvrage.xmlparser;

import android.util.Log;

import com.example.jeff.tvrage.com.example.jeff.tvrage.objects.Show;
import com.example.jeff.tvrage.com.example.jeff.tvrage.xmlparser.feedreaders.FeedReader;
import com.example.jeff.tvrage.com.example.jeff.tvrage.xmlparser.feedreaders.ShowInfoFeedReader;

import org.xmlpull.v1.XmlPullParser;

/**
 * Created by Neutron-PC-Windows on 19-1-2015.
 */
public class ShowInfoParser {
    int sid;
    private volatile boolean isDone = false;

    public ShowInfoParser(int sid) {
        this.sid = sid;
    }

    public void parse() {
        String url = "http://services.tvrage.com/feeds/full_show_info.php?sid=" + sid;
        FeedReader feedreader = new ShowInfoFeedReader();
        XMLParser obj = new XMLParser(url, feedreader);
        Log.w("tvrage", "started parsing");

        //todo update ui with waiting status
        while(feedreader.isDone() == false) {

        }

        try {
            Show show = (Show) feedreader.getParsedObject();
            show.getName();
        } catch(Exception e) {
            e.printStackTrace();
        }

        Log.w("tvrage", "done with parsing");

        this.isDone = true;
    }

}