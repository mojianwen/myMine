package com.mining.safety.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mining.safety.entity.Classroom;
import com.mining.safety.mapper.ClassroomMapper;
import com.mining.safety.service.ClassroomService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class ClassroomServiceImpl extends ServiceImpl<ClassroomMapper, Classroom> implements ClassroomService {

    @Override
    public Page<Classroom> pageList(Page<Classroom> page, String name, Integer status) {
        LambdaQueryWrapper<Classroom> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(StringUtils.hasText(name), Classroom::getName, name);
        wrapper.eq(status != null, Classroom::getStatus, status);
        wrapper.orderByDesc(Classroom::getCreateTime);
        return page(page, wrapper);
    }

    @Override
    public void sign(Long id) {
        Classroom classroom = getById(id);
        if (classroom != null) {
            classroom.setParticipantCount(classroom.getParticipantCount() + 1);
            updateById(classroom);
        }
    }
}
