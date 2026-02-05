package com.mining.safety.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mining.safety.entity.Material;
import com.mining.safety.mapper.MaterialMapper;
import com.mining.safety.service.MaterialService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class MaterialServiceImpl extends ServiceImpl<MaterialMapper, Material> implements MaterialService {
    
    @Override
    public IPage<Material> queryMaterialList(String name, String type, Integer page, Integer size) {
        Page<Material> pageParam = new Page<>(page, size);
        LambdaQueryWrapper<Material> wrapper = new LambdaQueryWrapper<>();
        if (StringUtils.isNotBlank(name)) {
            wrapper.like(Material::getName, name);
        }
        if (StringUtils.isNotBlank(type)) {
            wrapper.eq(Material::getType, type);
        }
        wrapper.eq(Material::getDeleted, 0);
        wrapper.orderByDesc(Material::getCreateTime);
        return this.page(pageParam, wrapper);
    }
}
