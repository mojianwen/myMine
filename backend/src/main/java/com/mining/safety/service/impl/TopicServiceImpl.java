package com.mining.safety.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mining.safety.entity.Topic;
import com.mining.safety.mapper.TopicMapper;
import com.mining.safety.service.TopicService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class TopicServiceImpl extends ServiceImpl<TopicMapper, Topic> implements TopicService {
    @Override
    public Page<Topic> getTopicPage(String name, Integer page, Integer size) {
        Page<Topic> pageParam = new Page<>(page, size);
        LambdaQueryWrapper<Topic> wrapper = new LambdaQueryWrapper<>();
        if (StringUtils.isNotBlank(name)) {
            wrapper.like(Topic::getName, name);
        }
        wrapper.orderByDesc(Topic::getCreateTime);
        return page(pageParam, wrapper);
    }
}
