<template>
  <div class="course-container">
    <el-card>
      <template #header>
        <div class="card-header">
          <span>培训课程管理</span>
          <el-button type="primary" @click="handleAdd">新增课程</el-button>
        </div>
      </template>
      
      <el-form :inline="true" :model="queryParams">
        <el-form-item label="课程名称">
          <el-input v-model="queryParams.name" placeholder="请输入课程名称" clearable />
        </el-form-item>
        <el-form-item label="课程类型">
          <el-select v-model="queryParams.type" placeholder="请选择类型" clearable>
            <el-option label="安全规程" value="safety" />
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
        <el-table-column prop="name" label="课程名称" />
        <el-table-column prop="type" label="课程类型">
          <template #default="scope">
            <el-tag :type="getTypeTagType(scope.row.type)">{{ getTypeName(scope.row.type) }}</el-tag>
          </template>
        </el-table-column>
        <el-table-column prop="duration" label="课程时长" />
        <el-table-column prop="trainer" label="培训师" />
        <el-table-column label="培训素材">
          <template #default="scope">
            <el-tag v-for="materialId in scope.row.materialIds" :key="materialId" style="margin-right: 5px;">
              {{ getMaterialName(materialId) }}
            </el-tag>
          </template>
        </el-table-column>
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
        <el-form-item label="课程名称" prop="name">
          <el-input v-model="form.name" />
        </el-form-item>
        <el-form-item label="课程类型" prop="type">
          <el-select v-model="form.type" placeholder="请选择类型">
            <el-option label="安全规程" value="safety" />
            <el-option label="操作技能" value="skill" />
            <el-option label="应急处理" value="emergency" />
          </el-select>
        </el-form-item>
        <el-form-item label="课程时长" prop="duration">
          <el-input v-model="form.duration" placeholder="课程时长(分钟)" />
        </el-form-item>
        <el-form-item label="培训师" prop="trainer">
          <el-input v-model="form.trainer" />
        </el-form-item>
        <el-form-item label="课程描述" prop="description">
          <el-input v-model="form.description" type="textarea" :rows="4" />
        </el-form-item>
        <el-form-item label="培训素材" prop="materialIds">
          <el-select
            v-model="form.materialIds"
            multiple
            placeholder="请选择培训素材"
            style="width: 100%"
          >
            <el-option
              v-for="item in materialList"
              :key="item.id"
              :label="item.name"
              :value="item.id"
            />
          </el-select>
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
import { getCourseList, addCourse, updateCourse, deleteCourse, getMaterialList } from '@/api/training'

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
  duration: '',
  trainer: '',
  description: '',
  status: 1,
  materialIds: []
})

const materialList = ref([])

const rules = {
  name: [{ required: true, message: '请输入课程名称', trigger: 'blur' }],
  type: [{ required: true, message: '请选择课程类型', trigger: 'change' }],
  duration: [{ required: true, message: '请输入课程时长', trigger: 'blur' }],
  trainer: [{ required: true, message: '请输入培训师', trigger: 'blur' }]
}

const getTypeName = (type) => {
  const typeMap = {
    safety: '安全规程',
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

const getMaterialName = (materialId) => {
  const material = materialList.value.find(item => item.id === materialId)
  return material ? material.name : ''
}

const handleQuery = async () => {
  try {
    const res = await getCourseList(queryParams.value)
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

const loadMaterialList = async () => {
  try {
    const res = await getMaterialList({ page: 1, size: 1000 })
    materialList.value = res.data.records || []
  } catch (error) {
    console.error(error)
  }
}

const handleAdd = () => {
  dialogTitle.value = '新增课程'
  form.value = {
    id: null,
    name: '',
    type: '',
    duration: '',
    trainer: '',
    description: '',
    status: 1,
    materialIds: []
  }
  dialogVisible.value = true
  loadMaterialList()
}

const handleEdit = (row) => {
  dialogTitle.value = '编辑课程'
  form.value = { 
    ...row,
    materialIds: row.materialIds || []
  }
  dialogVisible.value = true
  loadMaterialList()
}

const handleDelete = (row) => {
  ElMessageBox.confirm('确定要删除该课程吗?', '提示', {
    confirmButtonText: '确定',
    cancelButtonText: '取消',
    type: 'warning'
  }).then(async () => {
    try {
      await deleteCourse(row.id)
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
          await updateCourse(form.value)
          ElMessage.success('更新成功')
        } else {
          await addCourse(form.value)
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
  loadMaterialList()
})
</script>

<style scoped>
.course-container {
  padding: 20px;
}

.card-header {
  display: flex;
  justify-content: space-between;
  align-items: center;
}
</style>
