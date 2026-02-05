package com.mining.safety.controller;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mining.safety.common.Result;
import com.mining.safety.entity.Course;
import com.mining.safety.service.CourseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/training/course")
@Tag(name = "培训课程管理", description = "培训课程管理相关接口")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/list")
    @Operation(summary = "分页查询课程列表", description = "根据条件分页查询课程列表")
    public Result<IPage<Course>> list(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String type,
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer size) {
        IPage<Course> pageResult = courseService.queryCourseList(name, type, page, size);
        return Result.success(pageResult);
    }

    @PostMapping
    @Operation(summary = "添加课程", description = "添加新课程")
    public Result add(@RequestBody Course course) {
        course.setDeleted(0);
        courseService.save(course);
        // 保存课程素材关联
        if (course.getMaterialIds() != null && !course.getMaterialIds().isEmpty()) {
            courseService.saveCourseMaterials(course.getId(), course.getMaterialIds());
        }
        return Result.success("添加成功");
    }

    @PutMapping
    @Operation(summary = "修改课程", description = "修改课程信息")
    public Result update(@RequestBody Course course) {
        courseService.updateById(course);
        // 更新课程素材关联
        courseService.saveCourseMaterials(course.getId(), course.getMaterialIds());
        return Result.success("修改成功");
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "删除课程", description = "根据ID删除课程")
    public Result delete(@PathVariable Long id) {
        UpdateWrapper<Course> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id", id);
        updateWrapper.set("deleted", 1);
        courseService.update(updateWrapper);
        return Result.success("删除成功");
    }
}
