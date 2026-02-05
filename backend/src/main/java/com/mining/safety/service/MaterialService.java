package com.mining.safety.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mining.safety.entity.Material;

public interface MaterialService extends IService<Material> {
    IPage<Material> queryMaterialList(String name, String type, Integer page, Integer size);
}
