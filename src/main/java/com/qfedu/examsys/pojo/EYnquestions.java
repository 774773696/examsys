package com.qfedu.examsys.pojo;

public class EYnquestions {
    private int yqId;

    private String ytitle;

    private Integer yanswer;

    public Integer getYqId() {
        return yqId;
    }

    public void setYqId(Integer yqId) {
        this.yqId = yqId;
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