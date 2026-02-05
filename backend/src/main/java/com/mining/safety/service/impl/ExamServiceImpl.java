package com.mining.safety.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mining.safety.entity.Exam;
import com.mining.safety.mapper.ExamMapper;
import com.mining.safety.service.ExamService;
import org.springframework.stereotype.Service;

@Service
public class ExamServiceImpl extends ServiceImpl<ExamMapper, Exam> implements ExamService {
    @Override
    public IPage<Exam> queryExamList(String name, String type, Integer page, Integer size) {
        Page<Exam> pageParam = new Page<>(page, size);
        QueryWrapper<Exam> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("deleted", 0);
        if (name != null && !name.isEmpty()) {
            queryWrapper.like("name", name);
        }
        if (type != null && !type.isEmpty()) {
            queryWrapper.eq("type", type);
        }
        queryWrapper.orderByDesc("create_time");
        return page(pageParam, queryWrapper);
    }
}
