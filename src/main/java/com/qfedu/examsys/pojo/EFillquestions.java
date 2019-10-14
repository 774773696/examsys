package com.qfedu.examsys.pojo;

public class EFillquestions {
    private Integer fqid;

    private String ftitle;

    private String fanswer;

    public Integer getFqid() {
        return fqid;
    }

    public void setFqid(Integer fqid) {
        this.fqid = fqid;
    }

    public String getFtitle() {
        return ftitle;
    }

    public void setFtitle(String ftitle) {
        this.ftitle = ftitle == null ? null : ftitle.trim();
    }

    public String getFanswer() {
        return fanswer;
    }

    public void setFanswer(String fanswer) {
        this.fanswer = fanswer == null ? null : fanswer.trim();
    }
}