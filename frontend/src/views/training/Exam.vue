<template>
  <div class="exam-container">
    <el-card>
      <template #header>
        <div class="card-header">
          <span>培训试卷管理</span>
          <el-button type="primary" @click="handleAdd">新增试卷</el-button>
        </div>
      </template>
      
      <el-form :inline="true" :model="queryParams">
        <el-form-item label="试卷名称">
          <el-input v-model="queryParams.name" placeholder="请输入试卷名称" clearable />
        </el-form-item>
        <el-form-item label="试卷类型">
          <el-select v-model="queryParams.type" placeholder="请选择类型" clearable>
            <el-option label="安全知识" value="safety" />
            <el-option label="操作技能" value="skill" />
            <el-option label="应急处理" value="emergency" />
          </el-select>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="handleQuery">查询</el-button>
          <el-button @click="handleReset">重置</el-button>
        </el-form-item>
      </el-form>

      <el-table :data="tableData" border style="width: 100%">
        <el-table-column prop="id" label="ID" width="80" />
        <el-table-column prop="name" label="试卷名称" />
        <el-table-column prop="type" label="试卷类型">
          <template #default="scope">
            <el-tag :type="getTypeTagType(scope.row.type)">{{ getTypeName(scope.row.type) }}</el-tag>
          </template>
        </el-table-column>
        <el-table-column prop="totalScore" label="总分" />
        <el-table-column prop="duration" label="考试时长(分钟)" />
        <el-table-column prop="questionCount" label="题目数量" />
        <el-table-column prop="status" label="状态">
          <template #default="scope">
            <el-tag :type="scope.row.status === 1 ? 'success' : 'danger'">
              {{ scope.row.status === 1 ? '启用' : '禁用' }}
            </el-tag>
          </template>
        </el-table-column>
        <el-table-column label="操作" width="200">
          <template #default="scope">
            <el-button type="primary" link @click="handleEdit(scope.row)">编辑</el-button>
            <el-button type="danger" link @click="handleDelete(scope.row)">删除</el-button>
          </template>
        </el-table-column>
      </el-table>

      <el-pagination
        v-model:current-page="queryParams.page"
        v-model:page-size="queryParams.size"
        :total="total"
        :page-sizes="[10, 20, 50, 100]"
        layout="total, sizes, prev, pager, next, jumper"
        @size-change="handleQuery"
        @current-change="handleQuery"
        style="margin-top: 20px; justify-content: flex-end"
      />
    </el-card>

    <el-dialog
      v-model="dialogVisible"
      :title="dialogTitle"
      width="600px"
    >
      <el-form :model="form" :rules="rules" ref="formRef" label-width="100px">
        <el-form-item label="试卷名称" prop="name">
          <el-input v-model="form.name" />
        </el-form-item>
        <el-form-item label="试卷类型" prop="type">
          <el-select v-model="form.type" placeholder="请选择类型">
            <el-option label="安全知识" value="safety" />
            <el-option label="操作技能" value="skill" />
            <el-option label="应急处理" value="emergency" />
          </el-select>
        </el-form-item>
        <el-form-item label="总分" prop="totalScore">
          <el-input-number v-model="form.totalScore" :min="0" :max="100" />
        </el-form-item>
        <el-form-item label="考试时长" prop="duration">
          <el-input-number v-model="form.duration" :min="0" />
        </el-form-item>
        <el-form-item label="题目数量" prop="questionCount">
          <el-input-number v-model="form.questionCount" :min="0" />
        </el-form-item>
        <el-form-item label="状态" prop="status">
          <el-switch v-model="form.status" :active-value="1" :inactive-value="0" />
        </el-form-item>
      </el-form>
      <template #footer>
        <el-button @click="dialogVisible = false">取消</el-button>
        <el-button type="primary" @click="handleSubmit">确定</el-button>
      </template>
    </el-dialog>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue'
import { ElMessage, ElMessageBox } from 'element-plus'
import { getExamList, addExam, updateExam, deleteExam } from '@/api/training'

const queryParams = ref({
  page: 1,
  size: 10,
  name: '',
  type: ''
})

const tableData = ref([])
const total = ref(0)
const dialogVisible = ref(false)
const dialogTitle = ref('')
const formRef = ref(null)
const form = ref({
  id: null,
  name: '',
  type: '',
  totalScore: 100,
  duration: 60,
  questionCount: 0,
  status: 1
})

const rules = {
  name: [{ required: true, message: '请输入试卷名称', trigger: 'blur' }],
  type: [{ required: true, message: '请选择试卷类型', trigger: 'change' }],
  totalScore: [{ required: true, message: '请输入总分', trigger: 'blur' }],
  duration: [{ required: true, message: '请输入考试时长', trigger: 'blur' }],
  questionCount: [{ required: true, message: '请输入题目数量', trigger: 'blur' }]
}

const getTypeName = (type) => {
  const typeMap = {
    safety: '安全知识',
    skill: '操作技能',
    emergency: '应急处理'
  }
  return typeMap[type] || type
}

const getTypeTagType = (type) => {
  const typeMap = {
    safety: 'success',
    skill: 'primary',
    emergency: 'warning'
  }
  return typeMap[type] || ''
}

const handleQuery = async () => {
  try {
    const res = await getExamList(queryParams.value)
    tableData.value = res.data.records
    total.value = res.data.total
  } catch (error) {
    console.error(error)
  }
}

const handleReset = () => {
  queryParams.value = {
    page: 1,
    size: 10,
    name: '',
    type: ''
  }
  handleQuery()
}

const handleAdd = () => {
  dialogTitle.value = '新增试卷'
  form.value = {
    id: null,
    name: '',
    type: '',
    totalScore: 100,
    duration: 60,
    questionCount: 0,
    status: 1
  }
  dialogVisible.value = true
}

const handleEdit = (row) => {
  dialogTitle.value = '编辑试卷'
  form.value = { ...row }
  dialogVisible.value = true
}

const handleDelete = (row) => {
  ElMessageBox.confirm('确定要删除该试卷吗?', '提示', {
    confirmButtonText: '确定',
    cancelButtonText: '取消',
    type: 'warning'
  }).then(async () => {
    try {
      await deleteExam(row.id)
      ElMessage.success('删除成功')
      handleQuery()
    } catch (error) {
      console.error(error)
    }
  })
}

const handleSubmit = async () => {
  if (!formRef.value) return
  await formRef.value.validate(async (valid) => {
    if (valid) {
      try {
        if (form.value.id) {
          await updateExam(form.value)
          ElMessage.success('更新成功')
        } else {
          await addExam(form.value)
          ElMessage.success('添加成功')
        }
        dialogVisible.value = false
        handleQuery()
      } catch (error) {
        console.error(error)
      }
    }
  })
}

onMounted(() => {
  handleQuery()
})
</script>

<style scoped>
.exam-container {
  padding: 20px;
}

.card-header {
  display: flex;
  justify-content: space-between;
  align-items: center;
}
</style>
