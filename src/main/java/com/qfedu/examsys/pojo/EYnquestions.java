package com.qfedu.examsys.pojo;

public class EYnquestions {
    private Integer yqid;

    private String ytitle;

    private Integer yanswer;

    public Integer getYqid() {
        return yqid;
    }

    public void setYqid(Integer yqid) {
        this.yqid = yqid;
    }

    public String getYtitle() {
        return ytitle;
    }

    public void setYtitle(String ytitle) {
        this.ytitle = ytitle == null ? null : ytitle.trim();
    }

    public Integer getYanswer() {
        return yanswer;
    }

    public void setYanswer(Integer yanswer) {
        this.yanswer = yanswer;
    }
}