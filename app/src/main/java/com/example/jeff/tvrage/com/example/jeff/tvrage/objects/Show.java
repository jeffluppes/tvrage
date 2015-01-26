package com.example.jeff.tvrage.com.example.jeff.tvrage.objects;

/**
 * Created by Jeff on 21-1-2015.
 * Gebruikt voor detailinfo, niet voor het ophalen van de lijst.
 */
public class Show {

    String name;
    int sid;
    int totalSeasons;

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public int getTotalSeasons() {
        return totalSeasons;
    }

    public void setTotalSeasons(int totalSeasons) {
        this.totalSeasons = totalSeasons;
    }

    public String[] getGenres() {
        return genres;
    }

    public void setGenres(String[] genres) {
        this.genres = genres;
    }

    public String getOriginCountry() {
        return originCountry;
    }

    public void setOriginCountry(String originCountry) {
        this.originCountry = originCountry;
    }

    public String getStartedOn() {
        return startedOn;
    }

    public void setStartedOn(String startedOn) {
        this.startedOn = startedOn;
    }

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
