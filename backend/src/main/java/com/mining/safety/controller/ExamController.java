package com.mining.safety.controller;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mining.safety.common.Result;
import com.mining.safety.entity.Exam;
import com.mining.safety.service.ExamService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/training/exam")
@Tag(name = "培训试卷管理", description = "培训试卷管理相关接口")
public class ExamController {

    @Autowired
    private ExamService examService;

    @GetMapping("/list")
    @Operation(summary = "分页查询试卷列表", description = "根据条件分页查询试卷列表")
    public Result<IPage<Exam>> list(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String type,
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer size) {
        IPage<Exam> pageResult = examService.queryExamList(name, type, page, size);
        return Result.success(pageResult);
    }

    @PostMapping
    @Operation(summary = "添加试卷", description = "添加新试卷")
    public Result add(@RequestBody Exam exam) {
        exam.setDeleted(0);
        examService.save(exam);
        return Result.success("添加成功");
    }

    @PutMapping
    @Operation(summary = "修改试卷", description = "修改试卷信息")
    public Result update(@RequestBody Exam exam) {
        examService.updateById(exam);
        return Result.success("修改成功");
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "删除试卷", description = "根据ID删除试卷")
    public Result delete(@PathVariable Long id) {
        UpdateWrapper<Exam> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id", id);
        updateWrapper.set("deleted", 1);
        examService.update(updateWrapper);
        return Result.success("删除成功");
    }
}
