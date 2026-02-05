CREATE TABLE IF NOT EXISTS exam (
    id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '主键ID',
    name VARCHAR(100) NOT NULL COMMENT '试卷名称',
    type VARCHAR(50) NOT NULL COMMENT '试卷类型：safety-安全知识，skill-操作技能，emergency-应急处理',
    total_score INT NOT NULL DEFAULT 100 COMMENT '总分',
    duration INT NOT NULL COMMENT '考试时长(分钟)',
    question_count INT NOT NULL DEFAULT 0 COMMENT '题目数量',
    status INT NOT NULL DEFAULT 1 COMMENT '状态：0-禁用，1-启用',
    deleted INT NOT NULL DEFAULT 0 COMMENT '删除标记：0-未删除，1-已删除',
    create_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    INDEX idx_name (name),
    INDEX idx_type (type),
    INDEX idx_status (status),
    INDEX idx_deleted (deleted),
    INDEX idx_create_time (create_time)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='培训试卷表';
