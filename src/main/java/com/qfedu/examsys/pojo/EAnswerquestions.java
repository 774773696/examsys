package com.qfedu.examsys.pojo;

public class EAnswerquestions {
    private int aqId;

    private String atitle;

    private String aanswer;

    public Integer getAqId() {
        return aqId;
    }

    public void setAqId(Integer aqId) {
        this.aqId = aqId;
    }

    public String getAtitle() {
        return atitle;
    }

    public void setAtitle(String atitle) {
        this.atitle = atitle == null ? null : atitle.trim();
    }

    public String getAanswer() {
        return aanswer;
    }

    public void setAanswer(String aanswer) {
        this.aanswer = aanswer == null ? null : aanswer.trim();
    }
}