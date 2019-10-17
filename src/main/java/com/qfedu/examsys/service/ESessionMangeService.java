package com.qfedu.examsys.service;

import com.qfedu.examsys.vo.ESmVo;

import java.util.Date;
import java.util.List;

/**
 * @author TiAmo
 * @version v1.0
 * @date 2019/10/15 9:11
 */
public interface ESessionMangeService {
    public List<ESmVo> findAllSessionMangeByPage(Integer page, Integer limit,
                                                 String tpTitle, Date smBeginTime, String subjectName);

    public ESmVo findSessionMangeById(Integer smid);

    public void deleteSessionMange(Integer[] smids);

    public void deleteSessionMangeById(Integer smid);

    public void modifySessionMange(ESmVo eSmVo);

    public void addSessionMange(ESmVo eSmVo);
}
