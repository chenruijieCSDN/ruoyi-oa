import request from '@/utils/request'

// 查询 OA 公告管理列表
export function listNotice(query) {
  return request({
    url: '/system/oaNotice/list',
    method: 'get',
    params: query
  })
}

// 查询 OA 公告管理详细
export function getNotice(id) {
  return request({
    url: '/system/oaNotice/' + id,
    method: 'get'
  })
}

// 新增 OA 公告管理
export function addNotice(data) {
  return request({
    url: '/system/oaNotice',
    method: 'post',
    data: data
  })
}

// 修改 OA 公告管理
export function updateNotice(data) {
  return request({
    url: '/system/oaNotice',
    method: 'put',
    data: data
  })
}

// 发布 OA 公告
export function publishNotice(id) {
  return request({
    url: '/system/oaNotice/publish/' + id,
    method: 'put'
  })
}

// 删除 OA 公告管理
export function delNotice(id) {
  return request({
    url: '/system/oaNotice/' + id,
    method: 'delete'
  })
}
