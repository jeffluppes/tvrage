package com.example.jeff.tvrage.com.example.jeff.tvrage.xmlparser.feedreaders;

import android.util.Log;

import com.example.jeff.tvrage.com.example.jeff.tvrage.objects.Show;

import org.xmlpull.v1.XmlPullParser;

/**
 * Created by Jeff on 19-1-2015.
 */
public class ShowInfoFeedReader implements FeedReader {

    private boolean isDone = false;
    private Object parsedobject;

  public void readFeed(XmlPullParser parser) {
      int event;
      String text=null;
      Show show = new Show();
      try {
          event = parser.getEventType();
          while (event != XmlPullParser.END_DOCUMENT) {
              String name=parser.getName();
              switch (event){
                  case XmlPullParser.START_TAG:
                      break;
                  case XmlPullParser.TEXT:
                      text = parser.getText();
                      break;

                  case XmlPullParser.END_TAG:
                      if(name.equals("show")) {
                          show = new Show();
                      } else if(name.equals("name")){
                          show.setName(parser.getText());
                      } else if(name.equals("totalseasons")) {
                          //show.setTotalseasons(Integer.parseInt(parser.getAttributeValue(null, "value")));
                      } else {

                      }
                      break;
              }
              event = parser.next();

          }
      } catch (Exception e) {
          e.printStackTrace();
      }
      this.parsedobject = show;
      this.isDone = true;

  }

    public boolean isDone() {
        return this.isDone;
    }

    public Object getParsedObject() {
        return parsedobject;
    }
}
