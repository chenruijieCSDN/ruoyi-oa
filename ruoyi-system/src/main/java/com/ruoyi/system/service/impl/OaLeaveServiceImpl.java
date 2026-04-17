package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.OaLeaveMapper;
import com.ruoyi.system.domain.OaLeave;
import com.ruoyi.system.service.IOaLeaveService;

/**
 * 请假申请Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-04-17
 */
@Service
public class OaLeaveServiceImpl implements IOaLeaveService 
{
    @Autowired
    private OaLeaveMapper oaLeaveMapper;

    /**
     * 查询请假申请
     * 
     * @param id 请假申请主键
     * @return 请假申请
     */
    @Override
    public OaLeave selectOaLeaveById(Long id)
    {
        return oaLeaveMapper.selectOaLeaveById(id);
    }

    /**
     * 查询请假申请列表
     * 
     * @param oaLeave 请假申请
     * @return 请假申请
     */
    @Override
    public List<OaLeave> selectOaLeaveList(OaLeave oaLeave)
    {
        return oaLeaveMapper.selectOaLeaveList(oaLeave);
    }

    /**
     * 新增请假申请
     * 
     * @param oaLeave 请假申请
     * @return 结果
     */
    @Override
    public int insertOaLeave(OaLeave oaLeave)
    {
        oaLeave.setCreateTime(DateUtils.getNowDate());
        return oaLeaveMapper.insertOaLeave(oaLeave);
    }

    /**
     * 修改请假申请
     * 
     * @param oaLeave 请假申请
     * @return 结果
     */
    @Override
    public int updateOaLeave(OaLeave oaLeave)
    {
        oaLeave.setUpdateTime(DateUtils.getNowDate());
        return oaLeaveMapper.updateOaLeave(oaLeave);
    }

    /**
     * 批量删除请假申请
     * 
     * @param ids 需要删除的请假申请主键
     * @return 结果
     */
    @Override
    public int deleteOaLeaveByIds(Long[] ids)
    {
        return oaLeaveMapper.deleteOaLeaveByIds(ids);
    }

    /**
     * 删除请假申请信息
     * 
     * @param id 请假申请主键
     * @return 结果
     */
    @Override
    public int deleteOaLeaveById(Long id)
    {
        return oaLeaveMapper.deleteOaLeaveById(id);
    }
}
