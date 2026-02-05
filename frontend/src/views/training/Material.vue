<template>
  <div class="material-container">
    <el-card>
      <template #header>
        <div class="card-header">
          <span>培训素材管理</span>
          <el-button type="primary" @click="handleAdd">新增素材</el-button>
        </div>
      </template>
      
      <el-form :inline="true" :model="queryParams">
        <el-form-item label="素材名称">
          <el-input v-model="queryParams.name" placeholder="请输入素材名称" clearable />
        </el-form-item>
        <el-form-item label="素材类型">
          <el-select v-model="queryParams.type" placeholder="请选择类型" clearable>
            <el-option label="视频" value="video" />
            <el-option label="文档" value="document" />
            <el-option label="图片" value="image" />
          </el-select>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="handleQuery">查询</el-button>
          <el-button @click="handleReset">重置</el-button>
        </el-form-item>
      </el-form>

      <el-table :data="tableData" border style="width: 100%">
        <el-table-column prop="id" label="ID" width="80" />
        <el-table-column prop="name" label="素材名称" />
        <el-table-column prop="type" label="类型">
          <template #default="scope">
            <el-tag :type="getTypeTagType(scope.row.type)">{{ getTypeName(scope.row.type) }}</el-tag>
          </template>
        </el-table-column>
        <el-table-column prop="category" label="分类" />
        <el-table-column prop="duration" label="时长/页数" />
        <el-table-column prop="uploadTime" label="上传时间" />
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
        <el-form-item label="素材名称" prop="name">
          <el-input v-model="form.name" />
        </el-form-item>
        <el-form-item label="素材类型" prop="type">
          <el-select v-model="form.type" placeholder="请选择类型">
            <el-option label="视频" value="video" />
            <el-option label="文档" value="document" />
            <el-option label="图片" value="image" />
          </el-select>
        </el-form-item>
        <el-form-item label="分类" prop="category">
          <el-input v-model="form.category" />
        </el-form-item>
        <el-form-item label="时长/页数" prop="duration">
          <el-input v-model="form.duration" placeholder="视频时长或文档页数" />
        </el-form-item>
        <el-form-item label="上传文件" prop="file">
          <el-upload
            class="upload-demo"
            drag
            action="/api/training/material/upload"
            multiple
          >
            <el-icon class="el-icon--upload"><upload-filled /></el-icon>
            <div class="el-upload__text">
              将文件拖到此处，或<em>点击上传</em>
            </div>
          </el-upload>
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
import { UploadFilled } from '@element-plus/icons-vue'
import { getMaterialList, addMaterial, updateMaterial, deleteMaterial } from '@/api/training'

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
  category: '',
  duration: '',
  status: 1
})

const rules = {
  name: [{ required: true, message: '请输入素材名称', trigger: 'blur' }],
  type: [{ required: true, message: '请选择素材类型', trigger: 'change' }],
  category: [{ required: true, message: '请输入分类', trigger: 'blur' }]
}

const getTypeName = (type) => {
  const typeMap = {
    video: '视频',
    document: '文档',
    image: '图片'
  }
  return typeMap[type] || type
}

const getTypeTagType = (type) => {
  const typeMap = {
    video: 'success',
    document: 'primary',
    image: 'warning'
  }
  return typeMap[type] || ''
}

const handleQuery = async () => {
  try {
    const res = await getMaterialList(queryParams.value)
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
  dialogTitle.value = '新增素材'
  form.value = {
    id: null,
    name: '',
    type: '',
    category: '',
    duration: '',
    status: 1
  }
  dialogVisible.value = true
}

const handleEdit = (row) => {
  dialogTitle.value = '编辑素材'
  form.value = { ...row }
  dialogVisible.value = true
}

const handleDelete = (row) => {
  ElMessageBox.confirm('确定要删除该素材吗?', '提示', {
    confirmButtonText: '确定',
    cancelButtonText: '取消',
    type: 'warning'
  }).then(async () => {
    try {
      await deleteMaterial(row.id)
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
          await updateMaterial(form.value)
          ElMessage.success('更新成功')
        } else {
          await addMaterial(form.value)
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
.material-container {
  padding: 20px;
}

.card-header {
  display: flex;
  justify-content: space-between;
  align-items: center;
}
</style>
