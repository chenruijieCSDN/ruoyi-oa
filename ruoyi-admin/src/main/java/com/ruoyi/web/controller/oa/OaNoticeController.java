package com.ruoyi.web.controller.oa;

import java.util.List;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.OaNotice;
import com.ruoyi.system.service.IOaNoticeService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * OA 公告管理 Controller
 * 
 * @author ruoyi
 * @date 2026-04-17
 */
@RestController
@RequestMapping("/system/oaNotice")
public class OaNoticeController extends BaseController
{
    @Autowired
    private IOaNoticeService oaNoticeService;

    /**
     * 查询公告管理列表
     */
    @PreAuthorize("@ss.hasPermi('oa:notice:list')")
    @GetMapping("/list")
    public TableDataInfo list(OaNotice oaNotice)
    {
        startPage();
        List<OaNotice> list = oaNoticeService.selectOaNoticeList(oaNotice);
        return getDataTable(list);
    }

    /**
     * 导出公告管理列表
     */
    @PreAuthorize("@ss.hasPermi('oa:notice:export')")
    @Log(title = "OA公告管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, OaNotice oaNotice)
    {
        List<OaNotice> list = oaNoticeService.selectOaNoticeList(oaNotice);
        ExcelUtil<OaNotice> util = new ExcelUtil<OaNotice>(OaNotice.class);
        util.exportExcel(response, list, "OA公告管理数据");
    }

    /**
     * 获取公告管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('oa:notice:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(oaNoticeService.selectOaNoticeById(id));
    }

    /**
     * 新增公告管理
     */
    @PreAuthorize("@ss.hasPermi('oa:notice:add')")
    @Log(title = "OA公告管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody OaNotice oaNotice)
    {
        return toAjax(oaNoticeService.insertOaNotice(oaNotice));
    }

    /**
     * 修改公告管理
     */
    @PreAuthorize("@ss.hasPermi('oa:notice:edit')")
    @Log(title = "OA公告管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody OaNotice oaNotice)
    {
        return toAjax(oaNoticeService.updateOaNotice(oaNotice));
    }

    /**
     * 发布公告（状态改为已发布）
     */
    @PreAuthorize("@ss.hasPermi('oa:notice:publish')")
    @Log(title = "OA公告发布", businessType = BusinessType.UPDATE)
    @PutMapping("/publish/{id}")
    public AjaxResult publish(@PathVariable("id") Long id)
    {
        OaNotice notice = oaNoticeService.selectOaNoticeById(id);
        if (notice == null)
        {
            return AjaxResult.error("公告不存在");
        }
        notice.setStatus(1);
        return toAjax(oaNoticeService.updateOaNotice(notice));
    }

    /**
     * 删除公告管理
     */
    @PreAuthorize("@ss.hasPermi('oa:notice:remove')")
    @Log(title = "OA公告管理", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(oaNoticeService.deleteOaNoticeByIds(ids));
    }
}
