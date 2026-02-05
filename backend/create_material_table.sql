CREATE TABLE IF NOT EXISTS `material` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `name` varchar(255) NOT NULL COMMENT '素材名称',
  `type` varchar(50) NOT NULL COMMENT '素材类型：video-视频，document-文档，image-图片',
  `category` varchar(100) DEFAULT NULL COMMENT '分类',
  `duration` varchar(50) DEFAULT NULL COMMENT '时长/页数',
  `file_path` varchar(500) DEFAULT NULL COMMENT '文件路径',
  `status` tinyint DEFAULT '1' COMMENT '状态：1-启用，0-禁用',
  `deleted` tinyint DEFAULT '0' COMMENT '删除标记：0-未删除，1-已删除',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `idx_name` (`name`),
  KEY `idx_type` (`type`),
  KEY `idx_category` (`category`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='培训素材表';
