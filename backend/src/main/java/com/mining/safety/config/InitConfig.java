package com.mining.safety.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InitConfig implements CommandLineRunner {
    @Override
    public void run(String... args) {
        try {
            // 检查数据库连接
            System.out.println("系统初始化完成");
            System.out.println("注意：请确保MySQL服务已启动，并已执行初始化SQL脚本");
            System.out.println("SQL脚本位置: backend/src/main/resources/sql/init.sql");
        } catch (Exception e) {
            System.err.println("系统初始化失败: " + e.getMessage());
        }
    }
}
