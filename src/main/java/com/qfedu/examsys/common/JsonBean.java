package com.qfedu.examsys.common;

public class JsonBean<T> {

    /**
     * 返回数据状态编码，0正常返回，1失败
     */
    private int code;

    /**
     * 表示返回的具体数据，可以为null
     */
    private T info;

    public JsonBean() {
    }

    public JsonBean(int code, T info) {
        this.code = code;
        this.info = info;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }
}
