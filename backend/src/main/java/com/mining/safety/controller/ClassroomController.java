package com.mining.safety.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mining.safety.common.PageQuery;
import com.mining.safety.common.Result;
import com.mining.safety.entity.Classroom;
import com.mining.safety.service.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/classroom")
public class ClassroomController {

    @Autowired
    private ClassroomService classroomService;

    @GetMapping("/list")
    public Result<Page<Classroom>> list(PageQuery pageQuery, String name, Integer status) {
        Page<Classroom> page = new Page<>(pageQuery.getPage(), pageQuery.getSize());
        Page<Classroom> result = classroomService.pageList(page, name, status);
        return Result.success(result);
    }

    @PostMapping("/add")
    public Result<Void> add(@RequestBody Classroom classroom) {
        classroom.setParticipantCount(0);
        classroom.setStatus(0);
        classroomService.save(classroom);
        return Result.success();
    }

    @PutMapping("/update")
    public Result<Void> update(@RequestBody Classroom classroom) {
        classroomService.updateById(classroom);
        return Result.success();
    }

    @DeleteMapping("/delete/{id}")
    public Result<Void> delete(@PathVariable Long id) {
        classroomService.removeById(id);
        return Result.success();
    }

    @PostMapping("/sign/{id}")
    public Result<Void> sign(@PathVariable Long id) {
        classroomService.sign(id);
        return Result.success();
    }
}
