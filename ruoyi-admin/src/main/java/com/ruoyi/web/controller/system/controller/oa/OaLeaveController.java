package com.ruoyi.web.controller.system.controller.oa;

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
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.system.domain.OaLeave;
import com.ruoyi.system.service.IOaLeaveService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 请假申请Controller
 * 
 * @author ruoyi
 * @date 2026-04-17
 */
@RestController
@RequestMapping("/system/leave")
public class OaLeaveController extends BaseController
{
    @Autowired
    private IOaLeaveService oaLeaveService;

    /**
     * 查询请假申请列表
     */
    @PreAuthorize("@ss.hasPermi('oa:leave:list')")
    @GetMapping("/list")
    public TableDataInfo list(OaLeave oaLeave)
    {
        Long userId = SecurityUtils.getUserId();
        if (!SecurityUtils.isAdmin(userId))
        {
            oaLeave.setUserId(userId);
        }
        startPage();
        List<OaLeave> list = oaLeaveService.selectOaLeaveList(oaLeave);
        return getDataTable(list);
    }

    /**
     * 导出请假申请列表
     */
    @PreAuthorize("@ss.hasPermi('oa:leave:export')")
    @Log(title = "请假申请", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, OaLeave oaLeave)
    {
        Long userId = SecurityUtils.getUserId();
        if (!SecurityUtils.isAdmin(userId))
        {
            oaLeave.setUserId(userId);
        }
        List<OaLeave> list = oaLeaveService.selectOaLeaveList(oaLeave);
        ExcelUtil<OaLeave> util = new ExcelUtil<OaLeave>(OaLeave.class);
        util.exportExcel(response, list, "请假申请数据");
    }

    /**
     * 获取请假申请详细信息
     */
    @PreAuthorize("@ss.hasPermi('oa:leave:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(oaLeaveService.selectOaLeaveById(id));
    }

    /**
     * 新增请假申请
     */
    @PreAuthorize("@ss.hasPermi('oa:leave:add')")
    @Log(title = "请假申请", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody OaLeave oaLeave)
    {
        // 自动绑定当前登录用户，避免前端可伪造 userId
        oaLeave.setUserId(SecurityUtils.getUserId());
        if (oaLeave.getStatus() == null || oaLeave.getStatus().isBlank())
        {
            oaLeave.setStatus("0");
        }
        return toAjax(oaLeaveService.insertOaLeave(oaLeave));
    }

    /**
     * 修改请假申请
     */
    @PreAuthorize("@ss.hasPermi('oa:leave:edit')")
    @Log(title = "请假申请", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody OaLeave oaLeave)
    {
        return toAjax(oaLeaveService.updateOaLeave(oaLeave));
    }

    /**
     * 请假审批（通过/驳回）
     */
    @PreAuthorize("@ss.hasPermi('oa:leave:audit')")
    @Log(title = "请假审批", businessType = BusinessType.UPDATE)
    @PutMapping("/audit/{id}/{status}")
    public AjaxResult audit(@PathVariable Long id, @PathVariable String status)
    {
        if (!"1".equals(status) && !"2".equals(status))
        {
            return AjaxResult.error("审批状态无效，仅支持 1(通过) 或 2(驳回)");
        }
        OaLeave leave = oaLeaveService.selectOaLeaveById(id);
        if (leave == null)
        {
            return AjaxResult.error("请假记录不存在");
        }
        leave.setStatus(status);
        return toAjax(oaLeaveService.updateOaLeave(leave));
    }

    /**
     * 删除请假申请
     */
    @PreAuthorize("@ss.hasPermi('oa:leave:remove')")
    @Log(title = "请假申请", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(oaLeaveService.deleteOaLeaveByIds(ids));
    }
}
