import request from '@/router/axios'

export function roleList() {
  return request({
    url: '/user/role/roleList',
    method: 'get'
  })
}

export function fetchList(query) {
  return request({
    url: '/user/role/rolePage',
    method: 'get',
    params: query
  })
}

export function deptRoleList(deptId) {
  return request({
    url: '/user/role/roleList/' + deptId,
    method: 'get'
  })
}

export function getObj(id) {
  return request({
    url: '/user/role/' + id,
    method: 'get'
  })
}

export function addObj(obj) {
  return request({
    url: '/user/role/',
    method: 'post',
    data: obj
  })
}

export function putObj(obj) {
  return request({
    url: '/user/role/',
    method: 'put',
    data: obj
  })
}

export function delObj(id) {
  return request({
    url: '/user/role/' + id,
    method: 'delete'
  })
}

export function permissionUpd(roleId, menuIds) {
  return request({
    url: '/user/role/roleMenuUpd',
    method: 'put',
    params: {
      roleId: roleId,
      menuIds: menuIds
    }
  })
}

export function fetchRoleTree(roleName) {
  return request({
    url: '/user/menu/roleTree/' + roleName,
    method: 'get'
  })
}

export function fetchDeptTree(query) {
  return request({
    url: '/user/dept/tree',
    method: 'get',
    params: query
  })
}
