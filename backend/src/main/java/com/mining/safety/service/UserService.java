package com.mining.safety.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mining.safety.dto.UserQueryRequest;
import com.mining.safety.dto.UserSaveRequest;
import com.mining.safety.entity.User;

public interface UserService extends IService<User> {
    /**
     * 根据用户名查询用户
     */
    User findByUsername(String username);

    /**
     * 分页查询用户列表
     */
    IPage<User> queryUserList(UserQueryRequest request);

    /**
     * 添加用户
     */
    void addUser(UserSaveRequest request);

    /**
     * 修改用户
     */
    void updateUser(UserSaveRequest request);

    /**
     * 删除用户（逻辑删除）
     */
    void deleteUser(Long id);
}
