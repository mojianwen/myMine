package com.mining.safety.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("topic")
public class Topic {
    @TableId(type = IdType.AUTO)
    private Long id;
    
    private String name;
    
    private String category;
    
    private String description;
    
    private Integer courseCount;
    
    private Integer materialCount;
    
    private Integer status;
    
    @TableLogic
    private Integer deleted;
    
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;
    
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
}
