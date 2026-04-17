package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.OaNotice;

/**
 * 公告管理Service接口
 * 
 * @author ruoyi
 * @date 2026-04-17
 */
public interface IOaNoticeService 
{
    /**
     * 查询公告管理
     * 
     * @param id 公告管理主键
     * @return 公告管理
     */
    public OaNotice selectOaNoticeById(Long id);

    /**
     * 查询公告管理列表
     * 
     * @param oaNotice 公告管理
     * @return 公告管理集合
     */
    public List<OaNotice> selectOaNoticeList(OaNotice oaNotice);

    /**
     * 新增公告管理
     * 
     * @param oaNotice 公告管理
     * @return 结果
     */
    public int insertOaNotice(OaNotice oaNotice);

    /**
     * 修改公告管理
     * 
     * @param oaNotice 公告管理
     * @return 结果
     */
    public int updateOaNotice(OaNotice oaNotice);

    /**
     * 批量删除公告管理
     * 
     * @param ids 需要删除的公告管理主键集合
     * @return 结果
     */
    public int deleteOaNoticeByIds(Long[] ids);

    /**
     * 删除公告管理信息
     * 
     * @param id 公告管理主键
     * @return 结果
     */
    public int deleteOaNoticeById(Long id);
}
