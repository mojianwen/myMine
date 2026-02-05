package com.mining.safety.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mining.safety.common.Result;
import com.mining.safety.entity.Topic;
import com.mining.safety.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/training/topic")
public class TopicController {
    @Autowired
    private TopicService topicService;

    @GetMapping("/list")
    public Result<Page<Topic>> list(@RequestParam(required = false) String name,
                                     @RequestParam(defaultValue = "1") Integer page,
                                     @RequestParam(defaultValue = "10") Integer size) {
        Page<Topic> topicPage = topicService.getTopicPage(name, page, size);
        return Result.success(topicPage);
    }

    @PostMapping
    public Result<Void> add(@RequestBody Topic topic) {
        topicService.save(topic);
        return Result.success();
    }

    @PutMapping
    public Result<Void> update(@RequestBody Topic topic) {
        topicService.updateById(topic);
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result<Void> delete(@PathVariable Long id) {
        topicService.removeById(id);
        return Result.success();
    }
}
