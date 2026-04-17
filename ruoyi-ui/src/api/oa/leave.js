import request from '@/utils/request'

// 查询请假申请列表
export function listLeave(query) {
  return request({
    url: '/system/leave/list',
    method: 'get',
    params: query
  })
}

// 查询请假申请详细
export function getLeave(id) {
  return request({
    url: '/system/leave/' + id,
    method: 'get'
  })
}

// 新增请假申请
export function addLeave(data) {
  return request({
    url: '/system/leave',
    method: 'post',
    data: data
  })
}

// 修改请假申请
export function updateLeave(data) {
  return request({
    url: '/system/leave',
    method: 'put',
    data: data
  })
}

// 审批请假申请（1通过，2驳回）
export function auditLeave(id, status) {
  return request({
    url: '/system/leave/audit/' + id + '/' + status,
    method: 'put'
  })
}

// 删除请假申请
export function delLeave(id) {
  return request({
    url: '/system/leave/' + id,
    method: 'delete'
  })
}
