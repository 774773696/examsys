package com.qfedu.examsys.pojo;

public class EUserScore {
    private Integer usid;

    private Integer uid;

    private Integer tpid;

    private Double usscore;

    private Integer usstatus;

    private String uscontent;

    public Integer getUsid() {
        return usid;
    }

    public void setUsid(Integer usid) {
        this.usid = usid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getTpid() {
        return tpid;
    }

    public void setTpid(Integer tpid) {
        this.tpid = tpid;
    }

    public Double getUsscore() {
        return usscore;
    }

    public void setUsscore(Double usscore) {
        this.usscore = usscore;
    }

    public Integer getUsstatus() {
        return usstatus;
    }

    public void setUsstatus(Integer usstatus) {
        this.usstatus = usstatus;
    }

    public String getUscontent() {
        return uscontent;
    }

    public void setUscontent(String uscontent) {
        this.uscontent = uscontent == null ? null : uscontent.trim();
    }
}