package com.mining.safety.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("classroom")
public class Classroom {
    @TableId(type = IdType.AUTO)
    private Long id;
    
    private String name;
    
    private String trainer;
    
    private String location;
    
    private LocalDateTime startTime;
    
    private LocalDateTime endTime;
    
    private Integer maxParticipants;
    
    private Integer participantCount;
    
    private Integer status;
    
    private String description;
    
    @TableField(exist = false)
    private java.util.List<Long> materialIds;
    
    @TableLogic
    private Integer deleted;
    
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;
    
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
}
