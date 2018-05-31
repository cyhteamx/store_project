import request from '@/router/axios'

export function findMenuByUserName() {
  return request({
    url: '/user/menu/findMenuByUserName',
    method: 'get'
  })
}

export function GetMenu() {
  return request({
    url: '/user/menu/userMenu',
    method: 'get'
  })
}

export function fetchTree(query) {
  return request({
    url: '/user/menu/allTree',
    method: 'get',
    params: query
  })
}

export function fetchAll() {
  return request({
    url: '/user/menu/navMenu',
    method: 'get'
  })
}

export function fetchUserTree() {
  return request({
    url: '/user/menu/userTree',
    method: 'get'
  })
}

export function addObj(obj) {
  return request({
    url: '/user/menu/',
    method: 'post',
    data: obj
  })
}

export function getObj(id) {
  return request({
    url: '/user/menu/' + id,
    method: 'get'
  })
}

export function delObj(id) {
  return request({
    url: '/user/menu/' + id,
    method: 'delete'
  })
}

export function putObj(obj) {
  return request({
    url: '/user/menu/',
    method: 'put',
    data: obj
  })
}
