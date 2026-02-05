CREATE TABLE IF NOT EXISTS course_material (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    course_id BIGINT NOT NULL COMMENT '课程ID',
    material_id BIGINT NOT NULL COMMENT '素材ID',
    create_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    deleted TINYINT NOT NULL DEFAULT 0 COMMENT '删除标记 0-未删除 1-已删除',
    UNIQUE KEY uk_course_material (course_id, material_id),
    INDEX idx_course_id (course_id),
    INDEX idx_material_id (material_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='课程素材关联表';
