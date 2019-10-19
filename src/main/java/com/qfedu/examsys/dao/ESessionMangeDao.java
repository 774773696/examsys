package com.qfedu.examsys.dao;



import com.qfedu.examsys.pojo.ESessionMange;
import com.qfedu.examsys.vo.ESmVo;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author TiAmo
 * @version v1.0
 * @date 2019/10/15 9:09
 */
public interface ESessionMangeDao {
    /**
     * 查询所有考试场次信息
     * @param tpTitle 搜索时输入的考试标题
     * @param smBeginTime 搜索时输入的考试开始时间
     * @param subjectName 搜索时输入的考试科目类别
     * @return
     */
    public List<ESmVo> findAllSessionMange(@Param("tpTitle") String tpTitle,
                                           @Param("smBeginTime") Date smBeginTime,
                                           @Param("subjectName") String subjectName);

    /**
     * 根据id查询考试场次
     * @param smid
     * @return
     */
    public ESmVo findSessionmangeById(Integer smid);

    /**
     * 批量删除
     * @param smids 选中的id
     * 此处数组类型使用Integer 使用int时会出现类型转换错误
     */
    public void deleteSessionMange(Integer[] smids);

    /**
     * 根据指定id删除考试场次
     * @param smid
     */
    public void deleteSessionMangeById(Integer smid);

    /**
     * 修改对应考试场次
     * @param eSessionMange
     */
    public void modifySessionMange(ESessionMange eSessionMange);

    /**
     * 添加考试场次
     * @param eSessionMange
     */
    public void addSessionMange(ESessionMange eSessionMange);

}
