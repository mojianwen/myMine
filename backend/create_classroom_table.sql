CREATE TABLE IF NOT EXISTS classroom (
    id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT 'ID',
    name VARCHAR(100) NOT NULL COMMENT '课堂名称',
    trainer VARCHAR(50) NOT NULL COMMENT '培训师',
    location VARCHAR(100) NOT NULL COMMENT '地点',
    start_time DATETIME NOT NULL COMMENT '开始时间',
    end_time DATETIME NOT NULL COMMENT '结束时间',
    max_participants INT NOT NULL DEFAULT 30 COMMENT '最大人数',
    participant_count INT NOT NULL DEFAULT 0 COMMENT '参与人数',
    status INT NOT NULL DEFAULT 0 COMMENT '状态：0-未开始，1-进行中，2-已结束',
    description TEXT COMMENT '课堂描述',
    deleted INT NOT NULL DEFAULT 0 COMMENT '删除标记：0-未删除，1-已删除',
    create_time DATETIME COMMENT '创建时间',
    update_time DATETIME COMMENT '更新时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='线下课堂表';
