import request from '@/utils/request'

// 培训素材管理
export function getMaterialList(params) {
  return request({
    url: '/api/training/material/list',
    method: 'get',
    params
  })
}

export function addMaterial(data) {
  return request({
    url: '/api/training/material',
    method: 'post',
    data
  })
}

export function updateMaterial(data) {
  return request({
    url: '/api/training/material',
    method: 'put',
    data
  })
}

export function deleteMaterial(id) {
  return request({
    url: `/api/training/material/${id}`,
    method: 'delete'
  })
}

// 培训课程管理
export function getCourseList(params) {
  return request({
    url: '/api/training/course/list',
    method: 'get',
    params
  })
}

export function addCourse(data) {
  return request({
    url: '/api/training/course',
    method: 'post',
    data
  })
}

export function updateCourse(data) {
  return request({
    url: '/api/training/course',
    method: 'put',
    data
  })
}

export function deleteCourse(id) {
  return request({
    url: `/api/training/course/${id}`,
    method: 'delete'
  })
}

// 培训试卷管理
export function getExamList(params) {
  return request({
    url: '/api/training/exam/list',
    method: 'get',
    params
  })
}

export function addExam(data) {
  return request({
    url: '/api/training/exam',
    method: 'post',
    data
  })
}

export function updateExam(data) {
  return request({
    url: '/api/training/exam',
    method: 'put',
    data
  })
}

export function deleteExam(id) {
  return request({
    url: `/api/training/exam/${id}`,
    method: 'delete'
  })
}

// 培训专题管理
export function getTopicList(params) {
  return request({
    url: '/api/training/topic/list',
    method: 'get',
    params
  })
}

export function addTopic(data) {
  return request({
    url: '/api/training/topic',
    method: 'post',
    data
  })
}

export function updateTopic(data) {
  return request({
    url: '/api/training/topic',
    method: 'put',
    data
  })
}

export function deleteTopic(id) {
  return request({
    url: `/api/training/topic/${id}`,
    method: 'delete'
  })
}

// 线下课堂管理
export function getClassroomList(params) {
  return request({
    url: '/api/classroom/list',
    method: 'get',
    params
  })
}

export function addClassroom(data) {
  return request({
    url: '/api/classroom/add',
    method: 'post',
    data
  })
}

export function updateClassroom(data) {
  return request({
    url: '/api/classroom/update',
    method: 'put',
    data
  })
}

export function deleteClassroom(id) {
  return request({
    url: `/api/classroom/delete/${id}`,
    method: 'delete'
  })
}

export function signClassroom(id) {
  return request({
    url: `/api/classroom/sign/${id}`,
    method: 'post'
  })
}
