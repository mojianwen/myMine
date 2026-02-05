import request from '@/utils/request'

// 登录
export function login(data) {
  return request({
    url: '/api/user/login',
    method: 'post',
    data
  })
}

// 获取用户信息
export function getUserInfo() {
  return request({
    url: '/api/user/info',
    method: 'get'
  })
}

// 获取用户列表
export function getUserList(data) {
  return request({
    url: '/api/user/list',
    method: 'post',
    data
  })
}

// 添加用户
export function addUser(data) {
  return request({
    url: '/api/user/add',
    method: 'post',
    data
  })
}

// 更新用户
export function updateUser(data) {
  return request({
    url: '/api/user/update',
    method: 'post',
    data
  })
}

// 删除用户
export function deleteUser(id) {
  return request({
    url: `/api/user/delete/${id}`,
    method: 'delete'
  })
}
