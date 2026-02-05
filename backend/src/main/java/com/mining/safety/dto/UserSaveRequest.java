package com.mining.safety.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

/**
 * 用户添加/修改请求DTO
 */
@Data
public class UserSaveRequest {
    /**
     * 用户ID（修改时必填，添加时不填）
     */
    private Long id;

    /**
     * 用户名（必填）
     */
    @NotBlank(message = "用户名不能为空")
    private String username;

    /**
     * 密码（添加时必填，修改时可选）
     */
    private String password;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 手机号
     */
    @Pattern(regexp = "^1[3-9]\\d{9}$", message = "手机号格式不正确")
    private String phone;

    /**
     * 邮箱
     */
    @Email(message = "邮箱格式不正确")
    private String email;

    /**
     * 状态（0-禁用，1-启用）
     */
    private Integer status;
}
