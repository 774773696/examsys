package com.qfedu.examsys.service;

import com.qfedu.examsys.vo.ESmVo;

import java.util.Date;
import java.util.List;
import java.util.Map;

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

    /**
     * 添加场次信息时选择科目联动菜单的实现
     * @return
     */
    public List<Map<String, Object>> groupSessionType();
}
