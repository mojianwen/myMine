<template>
  <div class="classroom-container">
    <el-card>
      <template #header>
        <div class="card-header">
          <span>线下课堂管理</span>
          <el-button type="primary" @click="handleAdd">新增课堂</el-button>
        </div>
      </template>
      
      <el-form :inline="true" :model="queryParams">
        <el-form-item label="课堂名称">
          <el-input v-model="queryParams.name" placeholder="请输入课堂名称" clearable />
        </el-form-item>
        <el-form-item label="状态">
          <el-select v-model="queryParams.status" placeholder="请选择状态" clearable>
            <el-option label="未开始" value="0" />
            <el-option label="进行中" value="1" />
            <el-option label="已结束" value="2" />
          </el-select>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="handleQuery">查询</el-button>
          <el-button @click="handleReset">重置</el-button>
        </el-form-item>
      </el-form>

      <el-table :data="tableData" border style="width: 100%">
        <el-table-column prop="id" label="ID" width="80" />
        <el-table-column prop="name" label="课堂名称" />
        <el-table-column prop="trainer" label="培训师" />
        <el-table-column prop="location" label="地点" />
        <el-table-column prop="startTime" label="开始时间" />
        <el-table-column prop="endTime" label="结束时间" />
        <el-table-column prop="participantCount" label="参与人数" />
        <el-table-column prop="status" label="状态">
          <template #default="scope">
            <el-tag :type="getStatusTagType(scope.row.status)">{{ getStatusName(scope.row.status) }}</el-tag>
          </template>
        </el-table-column>
        <el-table-column label="操作" width="200">
          <template #default="scope">
            <el-button type="primary" link @click="handleEdit(scope.row)">编辑</el-button>
            <el-button type="success" link @click="handleSign(scope.row)" v-if="scope.row.status === 1">签到</el-button>
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
        <el-form-item label="课堂名称" prop="name">
          <el-input v-model="form.name" />
        </el-form-item>
        <el-form-item label="培训师" prop="trainer">
          <el-input v-model="form.trainer" />
        </el-form-item>
        <el-form-item label="地点" prop="location">
          <el-input v-model="form.location" />
        </el-form-item>
        <el-form-item label="开始时间" prop="startTime">
          <el-date-picker
            v-model="form.startTime"
            type="datetime"
            placeholder="选择开始时间"
            style="width: 100%"
          />
        </el-form-item>
        <el-form-item label="结束时间" prop="endTime">
          <el-date-picker
            v-model="form.endTime"
            type="datetime"
            placeholder="选择结束时间"
            style="width: 100%"
          />
        </el-form-item>
        <el-form-item label="最大人数" prop="maxParticipants">
          <el-input-number v-model="form.maxParticipants" :min="1" />
        </el-form-item>
        <el-form-item label="课堂描述" prop="description">
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
import { getClassroomList, addClassroom, updateClassroom, deleteClassroom, signClassroom, getMaterialList } from '@/api/training'

const queryParams = ref({
  page: 1,
  size: 10,
  name: '',
  status: ''
})

const tableData = ref([])
const total = ref(0)
const dialogVisible = ref(false)
const dialogTitle = ref('')
const formRef = ref(null)
const form = ref({
  id: null,
  name: '',
  trainer: '',
  location: '',
  startTime: '',
  endTime: '',
  maxParticipants: 30,
  description: '',
  materialIds: []
})

const materialList = ref([])

const rules = {
  name: [{ required: true, message: '请输入课堂名称', trigger: 'blur' }],
  trainer: [{ required: true, message: '请输入培训师', trigger: 'blur' }],
  location: [{ required: true, message: '请输入地点', trigger: 'blur' }],
  startTime: [{ required: true, message: '请选择开始时间', trigger: 'change' }],
  endTime: [{ required: true, message: '请选择结束时间', trigger: 'change' }]
}

const getStatusName = (status) => {
  const statusMap = {
    0: '未开始',
    1: '进行中',
    2: '已结束'
  }
  return statusMap[status] || '未知'
}

const getStatusTagType = (status) => {
  const statusMap = {
    0: 'info',
    1: 'success',
    2: 'danger'
  }
  return statusMap[status] || ''
}

const handleQuery = async () => {
  try {
    const res = await getClassroomList(queryParams.value)
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
    status: ''
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
  dialogTitle.value = '新增课堂'
  form.value = {
    id: null,
    name: '',
    trainer: '',
    location: '',
    startTime: '',
    endTime: '',
    maxParticipants: 30,
    description: '',
    materialIds: []
  }
  dialogVisible.value = true
  loadMaterialList()
}

const handleEdit = (row) => {
  dialogTitle.value = '编辑课堂'
  form.value = { 
    ...row,
    materialIds: row.materialIds || []
  }
  dialogVisible.value = true
  loadMaterialList()
}

const handleSign = (row) => {
  ElMessageBox.confirm('确定要签到该课堂吗?', '提示', {
    confirmButtonText: '确定',
    cancelButtonText: '取消',
    type: 'warning'
  }).then(async () => {
    try {
      await signClassroom(row.id)
      ElMessage.success('签到成功')
      handleQuery()
    } catch (error) {
      console.error(error)
    }
  })
}

const handleDelete = (row) => {
  ElMessageBox.confirm('确定要删除该课堂吗?', '提示', {
    confirmButtonText: '确定',
    cancelButtonText: '取消',
    type: 'warning'
  }).then(async () => {
    try {
      await deleteClassroom(row.id)
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
          await updateClassroom(form.value)
          ElMessage.success('更新成功')
        } else {
          await addClassroom(form.value)
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
.classroom-container {
  padding: 20px;
}

.card-header {
  display: flex;
  justify-content: space-between;
  align-items: center;
}
</style>
