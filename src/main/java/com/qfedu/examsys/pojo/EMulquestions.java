package com.qfedu.examsys.pojo;

public class EMulquestions {
    private Integer mqid;

    private String mtitle;

    private String moptiona;

    private String moptionb;

    private String moptionc;

    private String moptiond;

    private String manswer;

    public Integer getMqid() {
        return mqid;
    }

    public void setMqid(Integer mqid) {
        this.mqid = mqid;
    }

    public String getMtitle() {
        return mtitle;
    }

    public void setMtitle(String mtitle) {
        this.mtitle = mtitle == null ? null : mtitle.trim();
    }

    public String getMoptiona() {
        return moptiona;
    }

    public void setMoptiona(String moptiona) {
        this.moptiona = moptiona == null ? null : moptiona.trim();
    }

    public String getMoptionb() {
        return moptionb;
    }

    public void setMoptionb(String moptionb) {
        this.moptionb = moptionb == null ? null : moptionb.trim();
    }

    public String getMoptionc() {
        return moptionc;
    }

    public void setMoptionc(String moptionc) {
        this.moptionc = moptionc == null ? null : moptionc.trim();
    }

    public String getMoptiond() {
        return moptiond;
    }

    public void setMoptiond(String moptiond) {
        this.moptiond = moptiond == null ? null : moptiond.trim();
    }

    public String getManswer() {
        return manswer;
    }

    public void setManswer(String manswer) {
        this.manswer = manswer == null ? null : manswer.trim();
    }
}