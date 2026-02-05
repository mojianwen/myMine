CREATE TABLE IF NOT EXISTS topic (
    id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '主键ID',
    name VARCHAR(100) NOT NULL COMMENT '专题名称',
    category VARCHAR(50) NOT NULL COMMENT '分类',
    description TEXT COMMENT '专题描述',
    course_count INT DEFAULT 0 COMMENT '关联课程数',
    material_count INT DEFAULT 0 COMMENT '关联素材数',
    status INT DEFAULT 1 COMMENT '状态：1-启用，0-禁用',
    deleted INT DEFAULT 0 COMMENT '逻辑删除：0-未删除，1-已删除',
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    INDEX idx_name (name),
    INDEX idx_category (category),
    INDEX idx_status (status)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='培训专题表';
