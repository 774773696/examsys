package com.qfedu.examsys.pojo;

public class EAnswerquestions {
    private Integer aqid;

    private String atitle;

    private String aanswer;

    public Integer getAqid() {
        return aqid;
    }

    public void setAqid(Integer aqid) {
        this.aqid = aqid;
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