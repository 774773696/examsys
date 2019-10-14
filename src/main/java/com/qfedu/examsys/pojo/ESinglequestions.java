package com.qfedu.examsys.pojo;

public class ESinglequestions {
    private Integer sqid;

    private String stitle;

    private String soptiona;

    private String soptionb;

    private String soptionc;

    private String soptiond;

    private String sanswer;

    public Integer getSqid() {
        return sqid;
    }

    public void setSqid(Integer sqid) {
        this.sqid = sqid;
    }

    public String getStitle() {
        return stitle;
    }

    public void setStitle(String stitle) {
        this.stitle = stitle == null ? null : stitle.trim();
    }

    public String getSoptiona() {
        return soptiona;
    }

    public void setSoptiona(String soptiona) {
        this.soptiona = soptiona == null ? null : soptiona.trim();
    }

    public String getSoptionb() {
        return soptionb;
    }

    public void setSoptionb(String soptionb) {
        this.soptionb = soptionb == null ? null : soptionb.trim();
    }

    public String getSoptionc() {
        return soptionc;
    }

    public void setSoptionc(String soptionc) {
        this.soptionc = soptionc == null ? null : soptionc.trim();
    }

    public String getSoptiond() {
        return soptiond;
    }

    public void setSoptiond(String soptiond) {
        this.soptiond = soptiond == null ? null : soptiond.trim();
    }

    public String getSanswer() {
        return sanswer;
    }

    public void setSanswer(String sanswer) {
        this.sanswer = sanswer == null ? null : sanswer.trim();
    }
}