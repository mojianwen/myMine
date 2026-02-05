package com.mining.safety.controller;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mining.safety.common.Result;
import com.mining.safety.entity.Material;
import com.mining.safety.service.MaterialService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/training/material")
@Tag(name = "培训素材管理", description = "培训素材管理相关接口")
public class MaterialController {

    @Autowired
    private MaterialService materialService;

    @GetMapping("/list")
    @Operation(summary = "分页查询素材列表", description = "根据条件分页查询素材列表")
    public Result<IPage<Material>> list(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String type,
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer size) {
        IPage<Material> pageResult = materialService.queryMaterialList(name, type, page, size);
        return Result.success(pageResult);
    }

    @PostMapping
    @Operation(summary = "添加素材", description = "添加新素材")
    public Result add(@RequestBody Material material) {
        material.setDeleted(0);
        materialService.save(material);
        return Result.success("添加成功");
    }

    @PutMapping
    @Operation(summary = "修改素材", description = "修改素材信息")
    public Result update(@RequestBody Material material) {
        materialService.updateById(material);
        return Result.success("修改成功");
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "删除素材", description = "根据ID删除素材")
    public Result delete(@PathVariable Long id) {
        UpdateWrapper<Material> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id", id);
        updateWrapper.set("deleted", 1);
        materialService.update(updateWrapper);
        return Result.success("删除成功");
    }
}
