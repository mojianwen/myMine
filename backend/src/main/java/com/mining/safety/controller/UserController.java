package com.mining.safety.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mining.safety.common.Result;
import com.mining.safety.dto.UserQueryRequest;
import com.mining.safety.dto.UserSaveRequest;
import com.mining.safety.entity.User;
import com.mining.safety.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/user")
@Tag(name = "用户管理", description = "用户管理相关接口")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @PostMapping("/login")
    @Operation(summary = "用户登录", description = "用户登录接口")
    public Result login(@RequestBody User user) {
        // 从数据库查询用户
        User dbUser = userService.findByUsername(user.getUsername());
        
        // 验证用户是否存在
        if (dbUser == null) {
            return Result.error("用户名或密码错误");
        }
        
        // 验证密码（支持明文密码和 BCrypt 哈希密码）
        boolean passwordMatch = false;
        System.out.println("输入密码: " + user.getPassword());
        System.out.println("数据库密码: " + dbUser.getPassword());
        
        // 先尝试 BCrypt 验证
        passwordMatch = passwordEncoder.matches(user.getPassword(), dbUser.getPassword());
        System.out.println("BCrypt 密码匹配: " + passwordMatch);
        
        // 如果 BCrypt 验证失败，尝试明文密码验证
        if (!passwordMatch) {
            passwordMatch = user.getPassword().equals(dbUser.getPassword());
            System.out.println("明文密码匹配: " + passwordMatch);
        }
        
        if (!passwordMatch) {
            return Result.error("用户名或密码错误");
        }
        
        // 验证用户状态
        if (dbUser.getStatus() != 1) {
            return Result.error("用户已被禁用");
        }
        
        // 返回包含token和user信息的对象
        Map<String, Object> data = new HashMap<>();
        data.put("token", "admin-token-" + System.currentTimeMillis());
        data.put("user", dbUser);
        return Result.success(data);
    }

    @GetMapping("/info")
    @Operation(summary = "获取当前用户信息", description = "获取当前登录用户的信息")
    public Result info() {
        User user = new User();
        user.setUsername("admin");
        user.setRealName("管理员");
        return Result.success(user);
    }

    @PostMapping("/list")
    @Operation(summary = "分页查询用户列表", description = "根据条件分页查询用户列表")
    public Result<IPage<User>> list(@RequestBody UserQueryRequest request) {
        IPage<User> page = userService.queryUserList(request);
        return Result.success(page);
    }

    @PostMapping("/add")
    @Operation(summary = "添加用户", description = "添加新用户")
    public Result add(@Valid @RequestBody UserSaveRequest request) {
        try {
            userService.addUser(request);
            return Result.success("添加成功");
        } catch (Exception e) {
            return Result.error(e.getMessage());
        }
    }

    @PostMapping("/update")
    @Operation(summary = "修改用户", description = "修改用户信息")
    public Result update(@Valid @RequestBody UserSaveRequest request) {
        try {
            userService.updateUser(request);
            return Result.success("修改成功");
        } catch (Exception e) {
            return Result.error(e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "删除用户", description = "根据ID删除用户")
    public Result delete(@PathVariable Long id) {
        try {
            userService.deleteUser(id);
            return Result.success("删除成功");
        } catch (Exception e) {
            return Result.error(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "获取用户详情", description = "根据ID获取用户详细信息")
    public Result<User> getById(@PathVariable Long id) {
        User user = userService.getById(id);
        if (user == null) {
            return Result.error("用户不存在");
        }
        // 返回时不包含密码
        user.setPassword(null);
        return Result.success(user);
    }
}
