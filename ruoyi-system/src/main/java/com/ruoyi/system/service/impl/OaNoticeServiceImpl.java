package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.OaNoticeMapper;
import com.ruoyi.system.domain.OaNotice;
import com.ruoyi.system.service.IOaNoticeService;

/**
 * 公告管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-04-17
 */
@Service
public class OaNoticeServiceImpl implements IOaNoticeService 
{
    @Autowired
    private OaNoticeMapper oaNoticeMapper;

    /**
     * 查询公告管理
     * 
     * @param id 公告管理主键
     * @return 公告管理
     */
    @Override
    public OaNotice selectOaNoticeById(Long id)
    {
        return oaNoticeMapper.selectOaNoticeById(id);
    }

    /**
     * 查询公告管理列表
     * 
     * @param oaNotice 公告管理
     * @return 公告管理
     */
    @Override
    public List<OaNotice> selectOaNoticeList(OaNotice oaNotice)
    {
        return oaNoticeMapper.selectOaNoticeList(oaNotice);
    }

    /**
     * 新增公告管理
     * 
     * @param oaNotice 公告管理
     * @return 结果
     */
    @Override
    public int insertOaNotice(OaNotice oaNotice)
    {
        oaNotice.setCreateTime(DateUtils.getNowDate());
        return oaNoticeMapper.insertOaNotice(oaNotice);
    }

    /**
     * 修改公告管理
     * 
     * @param oaNotice 公告管理
     * @return 结果
     */
    @Override
    public int updateOaNotice(OaNotice oaNotice)
    {
        oaNotice.setUpdateTime(DateUtils.getNowDate());
        return oaNoticeMapper.updateOaNotice(oaNotice);
    }

    /**
     * 批量删除公告管理
     * 
     * @param ids 需要删除的公告管理主键
     * @return 结果
     */
    @Override
    public int deleteOaNoticeByIds(Long[] ids)
    {
        return oaNoticeMapper.deleteOaNoticeByIds(ids);
    }

    /**
     * 删除公告管理信息
     * 
     * @param id 公告管理主键
     * @return 结果
     */
    @Override
    public int deleteOaNoticeById(Long id)
    {
        return oaNoticeMapper.deleteOaNoticeById(id);
    }
}
