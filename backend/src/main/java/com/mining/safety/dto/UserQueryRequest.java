package com.mining.safety.dto;

import com.mining.safety.common.PageQuery;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 用户查询请求DTO
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class UserQueryRequest extends PageQuery {
    /**
     * 用户名（模糊查询）
     */
    private String username;

    /**
     * 真实姓名（模糊查询）
     */
    private String realName;

    /**
     * 手机号（模糊查询）
     */
    private String phone;

    /**
     * 邮箱（模糊查询）
     */
    private String email;

    /**
     * 状态（精确查询）
     */
    private Integer status;
}
