package com.mining.safety.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mining.safety.dto.UserQueryRequest;
import com.mining.safety.dto.UserSaveRequest;
import com.mining.safety.entity.User;
import com.mining.safety.mapper.UserMapper;
import com.mining.safety.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import jakarta.annotation.Resource;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Resource
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public User findByUsername(String username) {
        return getOne(new LambdaQueryWrapper<User>()
                .eq(User::getUsername, username));
    }

    @Override
    public IPage<User> queryUserList(UserQueryRequest request) {
        Page<User> page = new Page<>(request.getPage(), request.getSize());
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        
        // 用户名模糊查询
        if (StringUtils.hasText(request.getUsername())) {
            wrapper.like(User::getUsername, request.getUsername());
        }
        
        // 真实姓名模糊查询
        if (StringUtils.hasText(request.getRealName())) {
            wrapper.like(User::getRealName, request.getRealName());
        }
        
        // 手机号模糊查询
        if (StringUtils.hasText(request.getPhone())) {
            wrapper.like(User::getPhone, request.getPhone());
        }
        
        // 邮箱模糊查询
        if (StringUtils.hasText(request.getEmail())) {
            wrapper.like(User::getEmail, request.getEmail());
        }
        
        // 状态精确查询
        if (request.getStatus() != null) {
            wrapper.eq(User::getStatus, request.getStatus());
        }
        
        // 按创建时间倒序排列
        wrapper.orderByDesc(User::getCreateTime);
        
        return page(page, wrapper);
    }

    @Override
    public void addUser(UserSaveRequest request) {
        // 检查用户名是否已存在
        User existUser = findByUsername(request.getUsername());
        if (existUser != null) {
            throw new RuntimeException("用户名已存在");
        }
        
        // 创建新用户
        User user = new User();
        BeanUtils.copyProperties(request, user);
        
        // 密码加密
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        
        // 设置默认状态为启用
        if (user.getStatus() == null) {
            user.setStatus(1);
        }
        
        save(user);
    }

    @Override
    public void updateUser(UserSaveRequest request) {
        if (request.getId() == null) {
            throw new RuntimeException("用户ID不能为空");
        }
        
        User existUser = getById(request.getId());
        if (existUser == null) {
            throw new RuntimeException("用户不存在");
        }
        
        // 检查用户名是否被其他用户使用
        User usernameUser = findByUsername(request.getUsername());
        if (usernameUser != null && !usernameUser.getId().equals(request.getId())) {
            throw new RuntimeException("用户名已被其他用户使用");
        }
        
        // 更新用户信息
        User user = new User();
        BeanUtils.copyProperties(request, user);
        
        // 如果提供了新密码，则加密
        if (StringUtils.hasText(request.getPassword())) {
            user.setPassword(passwordEncoder.encode(request.getPassword()));
        } else {
            user.setPassword(existUser.getPassword());
        }
        
        updateById(user);
    }

    @Override
    public void deleteUser(Long id) {
        if (id == null) {
            throw new RuntimeException("用户ID不能为空");
        }
        
        User existUser = getById(id);
        if (existUser == null) {
            throw new RuntimeException("用户不存在");
        }
        
        // 逻辑删除
        removeById(id);
    }
}
