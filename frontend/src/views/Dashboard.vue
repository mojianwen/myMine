<template>
  <div class="dashboard">
    <el-row :gutter="20">
      <el-col :span="6">
        <el-card class="stat-card">
          <div class="stat-content">
            <el-icon class="stat-icon user-icon"><User /></el-icon>
            <div class="stat-info">
              <div class="stat-value">1,234</div>
              <div class="stat-label">总用户数</div>
            </div>
          </div>
        </el-card>
      </el-col>
      <el-col :span="6">
        <el-card class="stat-card">
          <div class="stat-content">
            <el-icon class="stat-icon course-icon"><Notebook /></el-icon>
            <div class="stat-info">
              <div class="stat-value">56</div>
              <div class="stat-label">培训课程</div>
            </div>
          </div>
        </el-card>
      </el-col>
      <el-col :span="6">
        <el-card class="stat-card">
          <div class="stat-content">
            <el-icon class="stat-icon exam-icon"><Edit /></el-icon>
            <div class="stat-info">
              <div class="stat-value">128</div>
              <div class="stat-label">培训试卷</div>
            </div>
          </div>
        </el-card>
      </el-col>
      <el-col :span="6">
        <el-card class="stat-card">
          <div class="stat-content">
            <el-icon class="stat-icon classroom-icon"><School /></el-icon>
            <div class="stat-info">
              <div class="stat-value">24</div>
              <div class="stat-label">线下课堂</div>
            </div>
          </div>
        </el-card>
      </el-col>
    </el-row>

    <el-row :gutter="20" style="margin-top: 20px">
      <el-col :span="12">
        <el-card>
          <template #header>
            <div class="card-header">
              <span>培训进度统计</span>
            </div>
          </template>
          <div class="chart-placeholder">
            <el-empty description="图表区域" />
          </div>
        </el-card>
      </el-col>
      <el-col :span="12">
        <el-card>
          <template #header>
            <div class="card-header">
              <span>培训完成率</span>
            </div>
          </template>
          <div class="chart-placeholder">
            <el-empty description="图表区域" />
          </div>
        </el-card>
      </el-col>
    </el-row>
  </div>
</template>

<script setup>
import { User, Notebook, Edit, School } from '@element-plus/icons-vue'
</script>

<style scoped>
.dashboard {
  padding: 20px;
}

.stat-card {
  cursor: pointer;
  transition: all 0.3s;
}

.stat-card:hover {
  transform: translateY(-5px);
  box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
}

.stat-content {
  display: flex;
  align-items: center;
  justify-content: space-between;
}

.stat-icon {
  font-size: 48px;
  padding: 10px;
  border-radius: 8px;
}

.user-icon {
  color: #409EFF;
  background-color: #ecf5ff;
}

.course-icon {
  color: #67C23A;
  background-color: #f0f9eb;
}

.exam-icon {
  color: #E6A23C;
  background-color: #fdf6ec;
}

.classroom-icon {
  color: #F56C6C;
  background-color: #fef0f0;
}

.stat-info {
  text-align: right;
}

.stat-value {
  font-size: 24px;
  font-weight: bold;
  color: #303133;
}

.stat-label {
  font-size: 14px;
  color: #909399;
  margin-top: 5px;
}

.card-header {
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.chart-placeholder {
  height: 300px;
  display: flex;
  align-items: center;
  justify-content: center;
}
</style>