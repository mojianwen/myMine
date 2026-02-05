-- 更新 admin 用户密码为 admin123 的 BCrypt 哈希值
UPDATE `user` 
SET `password` = '$2a$10$N.zmdr9k7uOCQb376NoUnuTJ8iAt6Z5EHsM8lE9lBOsl7iKTVKIUi'
WHERE `username` = 'admin';
