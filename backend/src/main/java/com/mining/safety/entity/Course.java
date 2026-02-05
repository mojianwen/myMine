package com.mining.safety.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@TableName("course")
public class Course {
    
    @TableId(type = IdType.AUTO)
    private Long id;
    
    private String name;
    
    private String type;
    
    private String duration;
    
    private String trainer;
    
    @TableField(typeHandler = org.apache.ibatis.type.StringTypeHandler.class)
    private String description;
    
    private Integer status;
    
    private Integer deleted;
    
    private LocalDateTime createTime;
    
    private LocalDateTime updateTime;
    
    @TableField(exist = false)
    private List<Long> materialIds;
}
