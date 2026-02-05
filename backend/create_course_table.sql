CREATE TABLE IF NOT EXISTS `course` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `name` varchar(100) NOT NULL COMMENT '课程名称',
  `type` varchar(50) NOT NULL COMMENT '课程类型：safety-安全规程，skill-操作技能，emergency-应急处理',
  `duration` varchar(50) DEFAULT NULL COMMENT '课程时长',
  `trainer` varchar(50) DEFAULT NULL COMMENT '培训师',
  `description` text COMMENT '课程描述',
  `status` tinyint DEFAULT '1' COMMENT '状态：0-禁用，1-启用',
  `deleted` tinyint DEFAULT '0' COMMENT '删除标记：0-未删除，1-已删除',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `idx_type` (`type`),
  KEY `idx_deleted` (`deleted`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='培训课程表';
