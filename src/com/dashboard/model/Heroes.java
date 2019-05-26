package com.dashboard.model;

public class Heroes {
    private int heroid;
    private String heroname;
    private String eyecolor;
    private String haircolor;
    private String skincolor;
    private int height;
    private int weight;
    private String race;
    private int publisherid;
    private String publishername;
    private int genderid;
    private int alignmentid;
    private String alignmentname;

    public Heroes() {
    }

    public Heroes(int publisherid, int alignmentid, String race) {
        this.publisherid = publisherid;
        this.alignmentid = alignmentid;
        this.race = race;
    }

    public Heroes(int heroid, String heroname, String eyecolor, String haircolor, String skincolor, int height, int weight, String race, int publisherid, int genderid, int alignmentid) {
        this.heroid = heroid;
        this.heroname = heroname;
        this.eyecolor = eyecolor;
        this.haircolor = haircolor;
        this.skincolor = skincolor;
        this.height = height;
        this.weight = weight;
        this.race = race;
        this.publisherid = publisherid;
        this.genderid = genderid;
        this.alignmentid = alignmentid;
    }

    public Heroes(int heroid) {
        this.heroid = heroid;
    }




    public int getHeroid() {
        return heroid;
    }

    public void setHeroid(int heroid) {
        this.heroid = heroid;
    }

    public String getHeroname() {
        return heroname;
    }

    public void setHeroname(String heroname) {
        this.heroname = heroname;
    }

    public String getEyecolor() {
        return eyecolor;
    }

    public void setEyecolor(String eyecolor) {
        this.eyecolor = eyecolor;
    }

    public String getHaircolor() {
        return haircolor;
    }

    public void setHaircolor(String haircolor) {
        this.haircolor = haircolor;
    }

    public String getSkincolor() {
        return skincolor;
    }

    public void setSkincolor(String skincolor) {
        this.skincolor = skincolor;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public int getPublisherid() {
        return publisherid;
    }

    public void setPublisherid(int publisherid) {
        this.publisherid = publisherid;
    }

    public String getPublishername() {
        return publishername;
    }

    public void setPublishername(String publishername) {
        this.publishername = publishername;
    }

    public int getGenderid() {
        return genderid;
    }

    public void setGenderid(int genderid) {
        this.genderid = genderid;
    }

    public int getAlignmentid() {
        return alignmentid;
    }

    public void setAlignmentid(int alignmentid) {
        this.alignmentid = alignmentid;
    }

    public String getAlignmentname() {
        return alignmentname;
    }

    public void setAlignmentname(String alignmentname) {
        this.alignmentname = alignmentname;
    }
}