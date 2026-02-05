package com.mining.safety.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mining.safety.entity.Course;
import com.mining.safety.entity.CourseMaterial;
import com.mining.safety.mapper.CourseMapper;
import com.mining.safety.mapper.CourseMaterialMapper;
import com.mining.safety.service.CourseService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements CourseService {
    
    @Autowired
    private CourseMaterialMapper courseMaterialMapper;
    
    @Override
    public IPage<Course> queryCourseList(String name, String type, Integer page, Integer size) {
        Page<Course> pageParam = new Page<>(page, size);
        LambdaQueryWrapper<Course> wrapper = new LambdaQueryWrapper<>();
        if (StringUtils.isNotBlank(name)) {
            wrapper.like(Course::getName, name);
        }
        if (StringUtils.isNotBlank(type)) {
            wrapper.eq(Course::getType, type);
        }
        wrapper.eq(Course::getDeleted, 0);
        wrapper.orderByDesc(Course::getCreateTime);
        IPage<Course> result = this.page(pageParam, wrapper);
        
        // 为每个课程加载关联的素材ID
        result.getRecords().forEach(course -> {
            List<Long> materialIds = getCourseMaterialIds(course.getId());
            course.setMaterialIds(materialIds);
        });
        
        return result;
    }
    
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveCourseMaterials(Long courseId, List<Long> materialIds) {
        // 先删除该课程的所有素材关联
        LambdaQueryWrapper<CourseMaterial> deleteWrapper = new LambdaQueryWrapper<>();
        deleteWrapper.eq(CourseMaterial::getCourseId, courseId);
        courseMaterialMapper.delete(deleteWrapper);
        
        // 如果有新的素材ID，则创建新的关联
        if (materialIds != null && !materialIds.isEmpty()) {
            List<CourseMaterial> courseMaterials = materialIds.stream()
                .map(materialId -> {
                    CourseMaterial cm = new CourseMaterial();
                    cm.setCourseId(courseId);
                    cm.setMaterialId(materialId);
                    cm.setCreateTime(java.time.LocalDateTime.now());
                    cm.setUpdateTime(java.time.LocalDateTime.now());
                    return cm;
                })
                .collect(Collectors.toList());
            courseMaterials.forEach(courseMaterialMapper::insert);
        }
    }
    
    @Override
    public List<Long> getCourseMaterialIds(Long courseId) {
        LambdaQueryWrapper<CourseMaterial> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(CourseMaterial::getCourseId, courseId);
        wrapper.select(CourseMaterial::getMaterialId);
        return courseMaterialMapper.selectList(wrapper).stream()
            .map(CourseMaterial::getMaterialId)
            .collect(Collectors.toList());
    }
}
