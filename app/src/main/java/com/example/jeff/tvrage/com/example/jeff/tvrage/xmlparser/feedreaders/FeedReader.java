package com.example.jeff.tvrage.com.example.jeff.tvrage.xmlparser.feedreaders;

import org.xmlpull.v1.XmlPullParser;

/**
 * Created by Neutron-PC-Windows on 19-1-2015.
 */
public interface FeedReader {
    public void readFeed(XmlPullParser parser);
    public boolean isDone();
    public Object getParsedObject();
}
