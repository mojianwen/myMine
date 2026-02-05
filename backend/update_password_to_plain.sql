-- 更新 admin 用户密码为明文 123456
UPDATE `user` 
SET `password` = '123456'
WHERE `username` = 'admin';
