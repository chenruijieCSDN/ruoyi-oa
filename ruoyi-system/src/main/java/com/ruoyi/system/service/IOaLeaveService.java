package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.OaLeave;

/**
 * 请假申请Service接口
 * 
 * @author ruoyi
 * @date 2026-04-17
 */
public interface IOaLeaveService 
{
    /**
     * 查询请假申请
     * 
     * @param id 请假申请主键
     * @return 请假申请
     */
    public OaLeave selectOaLeaveById(Long id);

    /**
     * 查询请假申请列表
     * 
     * @param oaLeave 请假申请
     * @return 请假申请集合
     */
    public List<OaLeave> selectOaLeaveList(OaLeave oaLeave);

    /**
     * 新增请假申请
     * 
     * @param oaLeave 请假申请
     * @return 结果
     */
    public int insertOaLeave(OaLeave oaLeave);

    /**
     * 修改请假申请
     * 
     * @param oaLeave 请假申请
     * @return 结果
     */
    public int updateOaLeave(OaLeave oaLeave);

    /**
     * 批量删除请假申请
     * 
     * @param ids 需要删除的请假申请主键集合
     * @return 结果
     */
    public int deleteOaLeaveByIds(Long[] ids);

    /**
     * 删除请假申请信息
     * 
     * @param id 请假申请主键
     * @return 结果
     */
    public int deleteOaLeaveById(Long id);
}
