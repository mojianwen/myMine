package com.mining.safety.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mining.safety.entity.Classroom;

public interface ClassroomService extends IService<Classroom> {
    Page<Classroom> pageList(Page<Classroom> page, String name, Integer status);
    
    void sign(Long id);
}
