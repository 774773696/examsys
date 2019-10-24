package com.qfedu.examsys.vo;

import com.qfedu.examsys.pojo.ETestpaper;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author TiAmo
 * @version v1.0
 * @date 2019/10/15 11:36
 * 场次显示 vo类
 */
@Data
public class ESmVo {
    private Integer smid;
    private String tpTitle;
    private Date smBeginTime;
    private Date smEndTime;
    private String subjectName;

}
