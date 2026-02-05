package com.mining.safety.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mining.safety.entity.Exam;

public interface ExamService extends IService<Exam> {
    IPage<Exam> queryExamList(String name, String type, Integer page, Integer size);
}
