package com.qfedu.examsys.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author TiAmo
 * @version v1.0
 * @date 2019/10/15 9:04
 * 场次管理类
 */
@Data
public class ESessionMange implements Serializable {
    private Integer smid; //场次id
    private Integer tpid; // 试卷id
    private Date smBeginTime; //场次开始时间
    private Date smEndTime; // 场次结束时间
}
