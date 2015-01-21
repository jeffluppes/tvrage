package com.example.jeff.tvrage.com.example.jeff.tvrage.objects;

/**
 * Created by Jeff on 21-1-2015.
 * Gebruikt voor detailinfo, niet voor het ophalen van de lijst.
 */
public class Show {

    String name;
    int sid;
    int totalSeasons;
    String[] genres;
    String originCountry;
    String startedOn;

    public String getName() {
        return this.name;
    }


    public void setName(String name) {
        this.name = name;
    }
}
