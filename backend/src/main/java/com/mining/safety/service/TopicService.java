package com.mining.safety.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mining.safety.entity.Topic;

public interface TopicService extends IService<Topic> {
    Page<Topic> getTopicPage(String name, Integer page, Integer size);
}
