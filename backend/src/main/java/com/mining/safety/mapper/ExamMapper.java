package com.mining.safety.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mining.safety.entity.Exam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ExamMapper extends BaseMapper<Exam> {
    IPage<Exam> queryExamList(Page<Exam> page, @Param("name") String name, @Param("type") String type);
}
