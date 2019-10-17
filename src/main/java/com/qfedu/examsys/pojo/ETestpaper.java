package com.qfedu.examsys.pojo;

public class ETestpaper {
    private Integer tpid;

    private String tptitle;

    private Integer tid;

    private String tptime;

    private Integer tpscore;

    private Integer subjectId;

    private String tpcontext;

    public Integer getTpid() {
        return tpid;
    }

    public void setTpid(Integer tpid) {
        this.tpid = tpid;
    }

    public String getTptitle() {
        return tptitle;
    }

    public void setTptitle(String tptitle) {
        this.tptitle = tptitle == null ? null : tptitle.trim();
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getTptime() {
        return tptime;
    }

    public void setTptime(String tptime) {
        this.tptime = tptime == null ? null : tptime.trim();
    }

    public Integer getTpscore() {
        return tpscore;
    }

    public void setTpscore(Integer tpscore) {
        this.tpscore = tpscore;
    }

    public Integer getsubjectId() {
        return subjectId;
    }

    public void setsubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public String getTpcontext() {
        return tpcontext;
    }

    public void setTpcontext(String tpcontext) {
        this.tpcontext = tpcontext == null ? null : tpcontext.trim();
    }
}