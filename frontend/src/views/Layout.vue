<template>
  <el-container class="layout-container">
    <el-aside width="200px">
      <div class="logo">矿山安全培训</div>
      <el-menu
        :default-active="activeMenu"
        router
        background-color="#304156"
        text-color="#bfcbd9"
        active-text-color="#409EFF"
      >
        <el-menu-item index="/dashboard">
          <el-icon><House /></el-icon>
          <span>首页</span>
        </el-menu-item>
        <el-sub-menu index="system">
          <template #title>
            <el-icon><Setting /></el-icon>
            <span>系统管理</span>
          </template>
          <el-menu-item index="/user">
            <el-icon><User /></el-icon>
            <span>用户管理</span>
          </el-menu-item>
        </el-sub-menu>
        <el-sub-menu index="training">
          <template #title>
            <el-icon><Reading /></el-icon>
            <span>培训管理</span>
          </template>
          <el-menu-item index="/material">
            <el-icon><Document /></el-icon>
            <span>培训素材管理</span>
          </el-menu-item>
          <el-menu-item index="/course">
            <el-icon><Notebook /></el-icon>
            <span>培训课程管理</span>
          </el-menu-item>
          <el-menu-item index="/exam">
            <el-icon><Edit /></el-icon>
            <span>培训试卷管理</span>
          </el-menu-item>
          <el-menu-item index="/topic">
            <el-icon><Collection /></el-icon>
            <span>培训专题管理</span>
          </el-menu-item>
          <el-menu-item index="/classroom">
            <el-icon><School /></el-icon>
            <span>线下课堂</span>
          </el-menu-item>
        </el-sub-menu>
      </el-menu>
    </el-aside>
    <el-container>
      <el-header>
        <div class="header-content">
          <span class="breadcrumb">{{ currentTitle }}</span>
          <div class="user-info">
            <el-dropdown @command="handleCommand">
              <span class="el-dropdown-link">
                {{ userInfo.username }}
                <el-icon class="el-icon--right"><arrow-down /></el-icon>
              </span>
              <template #dropdown>
                <el-dropdown-menu>
                  <el-dropdown-item command="logout">退出登录</el-dropdown-item>
                </el-dropdown-menu>
              </template>
            </el-dropdown>
          </div>
        </div>
      </el-header>
      <el-main>
        <router-view />
      </el-main>
    </el-container>
  </el-container>
</template>

<script setup>
import { ref, computed } from 'vue'
import { useRoute, useRouter } from 'vue-router'
import { ElMessage } from 'element-plus'
import { getUserInfo } from '@/api/user'

const route = useRoute()
const router = useRouter()
const userInfo = ref({ username: '管理员' })

const activeMenu = computed(() => route.path)
const currentTitle = computed(() => route.meta.title || '首页')

const handleCommand = (command) => {
  if (command === 'logout') {
    localStorage.removeItem('token')
    router.push('/login')
    ElMessage.success('退出登录成功')
  }
}
</script>

<style scoped>
.layout-container {
  height: 100%;
}

.el-aside {
  background-color: #304156;
  color: #fff;
}

.logo {
  height: 60px;
  line-height: 60px;
  text-align: center;
  font-size: 18px;
  font-weight: bold;
  color: #fff;
  background-color: #2b2f3a;
}

.el-header {
  background-color: #fff;
  border-bottom: 1px solid #e6e6e6;
  display: flex;
  align-items: center;
  padding: 0 20px;
}

.header-content {
  width: 100%;
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.breadcrumb {
  font-size: 16px;
  color: #303133;
}

.user-info {
  display: flex;
  align-items: center;
}

.el-dropdown-link {
  cursor: pointer;
  color: #409EFF;
  display: flex;
  align-items: center;
}

.el-main {
  background-color: #f0f2f5;
  padding: 20px;
}
</style>