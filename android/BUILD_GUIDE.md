# Android APK 构建指南

## 前置条件

由于网络限制，无法自动下载Gradle Wrapper，请按照以下步骤手动构建APK。

## 方法一：使用 Android Studio（推荐）

### 步骤 1：安装 Android Studio

1. 下载 Android Studio: https://developer.android.com/studio
2. 安装并启动 Android Studio

### 步骤 2：打开项目

1. 选择 "Open an Existing Project"
2. 导航到 `android` 文件夹并选择它
3. 等待 Gradle 同步完成（首次同步可能需要较长时间）

### 步骤 3：配置 SDK

1. 打开 File > Project Structure > SDK Location
2. 设置 Android SDK 路径
3. 确保安装了 API 33 (Android 13)

### 步骤 4：构建 APK

1. 在菜单栏选择 Build > Build Bundle(s) / APK(s) > Build APK(s)
2. 等待构建完成
3. 构建成功后，会弹出通知，点击 "locate" 查找APK文件
4. APK文件位置：`android/app/build/outputs/apk/debug/app-debug.apk`

## 方法二：使用命令行

### 步骤 1：安装 Android SDK 命令行工具

1. 下载命令行工具: https://developer.android.com/studio#command-tools
2. 解压到指定目录，例如：`C:\Android\sdk`

### 步骤 2：设置环境变量

在 PowerShell 中执行：

```powershell
# 设置 ANDROID_HOME
$env:ANDROID_HOME = "C:\Android\sdk"

# 添加到 PATH
$env:PATH += ";$env:ANDROID_HOME\cmdline-tools\latest\bin"
$env:PATH += ";$env:ANDROID_HOME\platform-tools"
$env:PATH += ";$env:ANDROID_HOME\build-tools\33.0.0"

# 设置 JAVA_HOME
$env:JAVA_HOME = "C:\Program Files\Java\jdk-19"
$env:PATH += ";$env:JAVA_HOME\bin"
```

### 步骤 3：接受许可协议

```powershell
sdkmanager --licenses
```

### 步骤 4：安装必要的 SDK 组件

```powershell
sdkmanager "platform-tools" "platforms;android-33" "build-tools;33.0.0"
```

### 步骤 5：构建 APK

```powershell
cd android
.\gradlew.bat assembleDebug
```

构建成功后，APK文件位于：`android/app/build/outputs/apk/debug/app-debug.apk`

## 方法三：使用在线构建服务

如果本地环境配置困难，可以使用以下在线构建服务：

1. **GitHub Actions**
   - 将项目推送到 GitHub
   - 配置 GitHub Actions 工作流自动构建 APK
   - 从 Actions 页面下载构建产物

2. **Bitrise**
   - 注册 Bitrise 账号
   - 连接 GitHub 仓库
   - 配置构建工作流
   - 下载构建的 APK

## APK 安装

### 在 Android 设备上安装

1. 将 APK 文件传输到 Android 设备
2. 在设备上启用"未知来源"安装
3. 点击 APK 文件进行安装

### 使用 ADB 安装

```powershell
# 连接设备
adb devices

# 安装 APK
adb install android/app/build/outputs/apk/debug/app-debug.apk
```

## 常见问题

### Gradle 同步失败

- 检查网络连接
- 配置 Gradle 镜像源（见下方）
- 清理缓存：File > Invalidate Caches / Restart

### 配置 Gradle 镜像源

在 `android/build.gradle` 中添加：

```gradle
allprojects {
    repositories {
        maven { url 'https://maven.aliyun.com/repository/google' }
        maven { url 'https://maven.aliyun.com/repository/jcenter' }
        maven { url 'https://maven.aliyun.com/repository/public' }
        google()
        mavenCentral()
    }
}
```

### 构建错误

- 确保使用 JDK 17 或更高版本
- 检查 Android SDK 版本是否正确
- 清理并重新构建：Build > Clean Project，然后 Build > Rebuild Project

## 输出文件说明

构建成功后，会生成以下文件：

- **Debug APK**: `app/build/outputs/apk/debug/app-debug.apk`
  - 用于测试和调试
  - 包含调试信息
  - 未签名或使用调试签名

- **Release APK**: `app/build/outputs/apk/release/app-release.apk`
  - 用于正式发布
  - 已优化和混淆
  - 需要使用正式签名

## 签名 APK（发布版本）

如需生成签名的 Release APK：

1. 生成签名密钥：
   ```powershell
   keytool -genkey -v -keystore my-release-key.jks -keyalg RSA -keysize 2048 -validity 10000 -alias my-key-alias
   ```

2. 在 `android/app/build.gradle` 中配置签名：

```gradle
android {
    signingConfigs {
        release {
            storeFile file("my-release-key.jks")
            storePassword "your-store-password"
            keyAlias "my-key-alias"
            keyPassword "your-key-password"
        }
    }
    
    buildTypes {
        release {
            signingConfig signingConfigs.release
            minifyEnabled true
            proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'
        }
    }
}
```

3. 构建 Release APK：
   ```powershell
   .\gradlew.bat assembleRelease
   ```

## 联系支持

如遇到问题，请查看：
- Android Studio 官方文档: https://developer.android.com/studio
- Gradle 官方文档: https://docs.gradle.org/
- 项目 README.md
