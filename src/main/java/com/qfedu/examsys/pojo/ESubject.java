package com.qfedu.examsys.pojo;

public class ESubject {
    private Integer subjectId;

    private String subjectName;

    public Integer getsubjectId() {
        return subjectId;
    }

    public void setsubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public String getsubjectName() {
        return subjectName;
    }

    public void setsubjectName(String subjectName) {
        this.subjectName = subjectName == null ? null : subjectName.trim();
    }
}