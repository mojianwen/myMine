-- 重置 admin 用户密码为 admin123
-- 使用 BCryptPasswordEncoder 生成的新哈希值
UPDATE `user` 
SET `password` = '$2a$10$92IXUNpkjO0rOQ5byMi.Ye4oKoEa3Ro9llC/.og/at2.uheWG/igi'
WHERE `username` = 'admin';
