package com.mining.safety.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mining.safety.entity.Course;

public interface CourseService extends IService<Course> {
    IPage<Course> queryCourseList(String name, String type, Integer page, Integer size);
    
    void saveCourseMaterials(Long courseId, java.util.List<Long> materialIds);
    
    java.util.List<Long> getCourseMaterialIds(Long courseId);
}
