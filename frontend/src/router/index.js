import { createRouter, createWebHistory } from 'vue-router'

const routes = [
  {
    path: '/login',
    name: 'Login',
    component: () => import('@/views/Login.vue')
  },
  {
    path: '/',
    name: 'Layout',
    component: () => import('@/views/Layout.vue'),
    redirect: '/dashboard',
    children: [
      {
        path: 'dashboard',
        name: 'Dashboard',
        component: () => import('@/views/Dashboard.vue'),
        meta: { title: '首页' }
      },
      {
        path: 'user',
        name: 'User',
        component: () => import('@/views/system/User.vue'),
        meta: { title: '用户管理' }
      },
      {
        path: 'material',
        name: 'Material',
        component: () => import('@/views/training/Material.vue'),
        meta: { title: '培训素材管理' }
      },
      {
        path: 'course',
        name: 'Course',
        component: () => import('@/views/training/Course.vue'),
        meta: { title: '培训课程管理' }
      },
      {
        path: 'exam',
        name: 'Exam',
        component: () => import('@/views/training/Exam.vue'),
        meta: { title: '培训试卷管理' }
      },
      {
        path: 'topic',
        name: 'Topic',
        component: () => import('@/views/training/Topic.vue'),
        meta: { title: '培训专题管理' }
      },
      {
        path: 'classroom',
        name: 'Classroom',
        component: () => import('@/views/training/Classroom.vue'),
        meta: { title: '线下课堂' }
      }
    ]
  }
]

const router = createRouter({
  history: createWebHistory(),
  routes
})

// 路由守卫
router.beforeEach((to, from, next) => {
  const token = localStorage.getItem('token')
  if (to.path !== '/login' && !token) {
    next('/login')
  } else {
    next()
  }
})

export default router