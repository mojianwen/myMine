package com.mining.safety.config

object AppConfig {
    // 可以通过构建变体或环境变量来动态设置
    const val BASE_URL = "http://192.168.10.216:8080"
    
    // 或者可以考虑从资源文件或配置中读取
    fun getBaseUrl(): String {
        return BASE_URL
    }
}