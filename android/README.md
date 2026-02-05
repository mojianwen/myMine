# 矿山安全培训 Android 应用

## 项目概述
这是一个基于 Kotlin 开发的 Android 应用，用于矿山安全培训管理。

## 环境要求

### 必需工具
1. **Android Studio** (推荐) 或 Android SDK 命令行工具
   - 下载地址: https://developer.android.com/studio
   - 或命令行工具: https://developer.android.com/studio#command-tools

2. **Java JDK 17 或更高版本**
   - 下载地址: https://www.oracle.com/java/technologies/downloads/

3. **Gradle 8.0**
   - 项目已配置 Gradle Wrapper，首次运行会自动下载

## 启动步骤

### 方法一：使用 Android Studio（推荐）

1. **安装 Android Studio**
   - 下载并安装 Android Studio
   - 启动 Android Studio

2. **打开项目**
   - 选择 "Open an Existing Project"
   - 导航到 `android` 文件夹并选择它
   - 等待 Gradle 同步完成

3. **配置 SDK**
   - 打开 File > Project Structure > SDK Location
   - 设置 Android SDK 路径
   - 确保安装了 API 33 (Android 13)

4. **运行应用**
   - 连接 Android 设备或启动模拟器
   - 点击工具栏的运行按钮（绿色三角形）
   - 或按 Shift + F10

### 方法二：使用命令行

1. **设置环境变量**
   ```powershell
   # 设置 ANDROID_HOME
   $env:ANDROID_HOME = "C:\Users\YourName\AppData\Local\Android\Sdk"
   
   # 添加到 PATH
   $env:PATH += ";$env:ANDROID_HOME\platform-tools"
   $env:PATH += ";$env:ANDROID_HOME\emulator"
   ```

2. **构建项目**
   ```powershell
   cd android
   .\gradlew.bat build
   ```

3. **安装到设备**
   ```powershell
   # 连接设备或启动模拟器
   adb devices
   
   # 安装 APK
   .\gradlew.bat installDebug
   ```

## 项目结构

```
android/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/mining/safety/
│   │   │   │   ├── api/          # API 接口
│   │   │   │   ├── model/        # 数据模型
│   │   │   │   ├── repository/   # 数据仓库
│   │   │   │   ├── ui/           # UI 组件
│   │   │   │   └── viewmodel/    # ViewModel
│   │   │   ├── res/              # 资源文件
│   │   │   └── AndroidManifest.xml
│   │   └── build.gradle
│   └── build.gradle
├── build.gradle
├── settings.gradle
└── gradle.properties
```

## 主要功能

- 用户登录和认证
- 课程管理
- 教室管理
- 考试系统
- 学习资料管理
- 话题讨论

## 技术栈

- **语言**: Kotlin
- **架构**: MVVM
- **网络**: Retrofit + OkHttp
- **异步**: Kotlin Coroutines
- **UI**: Material Design
- **图片加载**: Glide
- **依赖注入**: 手动实现

## 常见问题

### Gradle 同步失败
- 检查网络连接
- 尝试使用 VPN 或配置 Gradle 镜像源
- 清理缓存: `.\gradlew.bat clean`

### SDK 未找到
- 在 Android Studio 中配置 SDK 路径
- 或设置 ANDROID_HOME 环境变量

### 构建错误
- 确保使用 JDK 17
- 清理并重新构建: `.\gradlew.bat clean build`

## 联系方式

如有问题，请联系开发团队。
